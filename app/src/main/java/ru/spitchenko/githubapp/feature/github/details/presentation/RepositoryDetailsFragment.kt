package ru.spitchenko.githubapp.feature.github.details.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import ru.spitchenko.githubapp.component.binderadapter.bindWith
import ru.spitchenko.githubapp.component.binderadapter.binderAdapterOf
import ru.spitchenko.githubapp.component.binderadapter.setBindingList
import ru.spitchenko.githubapp.component.navigation.initToolbar
import ru.spitchenko.githubapp.databinding.FragmentRepositoryDetailsBinding
import ru.spitchenko.githubapp.feature.github.details.presentation.model.AuthorUiModel
import ru.spitchenko.githubapp.feature.github.details.presentation.model.DescriptionUiModel
import ru.spitchenko.githubapp.feature.github.details.presentation.model.repositoryArgs
import ru.spitchenko.githubapp.feature.github.details.presentation.viewholder.AuthorViewHolderFactory
import ru.spitchenko.githubapp.feature.github.details.presentation.viewholder.DescriptionViewHolderFactory

class RepositoryDetailsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRepositoryDetailsBinding.inflate(inflater, container, false)

        binding.detailsList.adapter = binderAdapterOf(
            AuthorUiModel::class bindWith AuthorViewHolderFactory,
            DescriptionUiModel::class bindWith DescriptionViewHolderFactory
        )

        binding.detailsList.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        val repository = requireArguments().repositoryArgs.repository

        val details = DetailsConverter.convert(repository, requireContext())

        binding.detailsList.setBindingList(details)

        binding.toolbar.initToolbar(findNavController())

        binding.toolbar.title = repository.name

        return binding.root
    }
}