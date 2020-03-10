package ru.spitchenko.githubapp.feature.github.search.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import dagger.android.support.DaggerFragment
import ru.spitchenko.githubapp.R
import ru.spitchenko.githubapp.component.binderadapter.bindWith
import ru.spitchenko.githubapp.component.binderadapter.binderAdapterOf
import ru.spitchenko.githubapp.component.binderadapter.setBindingList
import ru.spitchenko.githubapp.component.binderadapter.viewHolderFactory
import ru.spitchenko.githubapp.component.lifecycle.ViewModelProviders
import ru.spitchenko.githubapp.component.lifecycle.viewModels
import ru.spitchenko.githubapp.component.ui.*
import ru.spitchenko.githubapp.databinding.FragmentSearchBinding
import ru.spitchenko.githubapp.databinding.ItemProgressBinding
import ru.spitchenko.githubapp.feature.github.search.presentation.model.ErrorUiModel
import ru.spitchenko.githubapp.feature.github.search.presentation.model.ProgressUiModel
import ru.spitchenko.githubapp.feature.github.search.presentation.model.RepositoryUiModel
import ru.spitchenko.githubapp.feature.github.search.presentation.model.UiState
import ru.spitchenko.githubapp.feature.github.search.presentation.viewholder.ErrorViewHolderFactory
import ru.spitchenko.githubapp.feature.github.search.presentation.viewholder.RepositoryViewHolderFactory
import javax.inject.Inject

class SearchFragment : DaggerFragment() {

    @Inject
    lateinit var providers: ViewModelProviders

    private val viewModel: SearchViewModel by viewModels { providers }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSearchBinding.inflate(inflater, container, false)

        binding.searchView.onQueryTextChange(viewModel::search)

        binding.retryButton.setOnClickListener {
            viewModel.retry()
        }

        binding.searchRefresh.setOnRefreshListener(viewModel::refresh)

        binding.searchList.onScrolledToFooter(viewModel::showNextPage)

        binding.searchList.adapter = binderAdapterOf(
            ProgressUiModel::class bindWith viewHolderFactory {
                ItemProgressBinding.inflate(it.context.layoutInflater, it, false)
            },
            ErrorUiModel::class bindWith ErrorViewHolderFactory(
                viewModel
            ),
            RepositoryUiModel::class bindWith RepositoryViewHolderFactory
        )

        viewModel.errorEvent.observe(viewLifecycleOwner) {
            requireContext().toast(it.getString(requireContext()))
        }

        viewModel.uiModel.observe(viewLifecycleOwner) { state ->
            when (state) {
                UiState.Empty -> {
                    binding.progress.visibility = View.GONE
                    binding.message.visibility = View.VISIBLE
                    binding.retryButton.visibility = View.GONE
                    binding.searchList.visibility = View.GONE
                    binding.message.text = getString(R.string.empty)
                    binding.searchRefresh.isEnabled = false
                    binding.searchRefresh.isRefreshing = false
                }
                UiState.NotFound -> {
                    binding.progress.visibility = View.GONE
                    binding.message.visibility = View.VISIBLE
                    binding.retryButton.visibility = View.GONE
                    binding.searchList.visibility = View.GONE
                    binding.message.text = getString(R.string.not_found)
                    binding.searchRefresh.isEnabled = true
                    binding.searchRefresh.isRefreshing = false
                }
                is UiState.Data -> {
                    binding.progress.visibility = View.GONE
                    binding.message.visibility = View.GONE
                    binding.retryButton.visibility = View.GONE
                    binding.searchList.visibility = View.VISIBLE
                    binding.searchList.setBindingList(state.items)
                    binding.searchRefresh.isEnabled = true
                    binding.searchRefresh.isRefreshing = false
                }
                is UiState.Error -> {
                    binding.progress.visibility = View.GONE
                    binding.message.visibility = View.VISIBLE
                    binding.retryButton.visibility = View.GONE
                    binding.searchList.visibility = View.GONE
                    binding.message.text = state.error.getString(requireContext())
                    binding.searchRefresh.isEnabled = true
                    binding.searchRefresh.isRefreshing = false
                }
                UiState.EmptyProgress -> {
                    binding.progress.visibility = View.VISIBLE
                    binding.message.visibility = View.GONE
                    binding.retryButton.visibility = View.GONE
                    binding.searchList.visibility = View.GONE
                    binding.searchRefresh.isEnabled = true
                    binding.searchRefresh.isRefreshing = false
                }
                is UiState.Refreshing.Data -> {
                    binding.progress.visibility = View.GONE
                    binding.message.visibility = View.GONE
                    binding.retryButton.visibility = View.GONE
                    binding.searchList.visibility = View.VISIBLE
                    binding.searchList.setBindingList(state.items)
                    binding.searchRefresh.isEnabled = true
                    binding.searchRefresh.isRefreshing = true
                }
                UiState.Refreshing.Empty -> {
                    binding.progress.visibility = View.GONE
                    binding.message.visibility = View.VISIBLE
                    binding.retryButton.visibility = View.GONE
                    binding.searchList.visibility = View.GONE
                    binding.searchRefresh.isEnabled = true
                    binding.searchRefresh.isRefreshing = true
                    binding.message.text = getString(R.string.empty)
                }
                is UiState.Refreshing.Error -> {
                    binding.progress.visibility = View.GONE
                    binding.message.visibility = View.VISIBLE
                    binding.retryButton.visibility = View.GONE
                    binding.searchList.visibility = View.GONE
                    binding.searchRefresh.isEnabled = true
                    binding.searchRefresh.isRefreshing = true
                    binding.message.text = state.error.getString(requireContext())
                }
            }
        }

        return binding.root
    }
}