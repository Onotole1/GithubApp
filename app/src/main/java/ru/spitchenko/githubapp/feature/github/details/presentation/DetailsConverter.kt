package ru.spitchenko.githubapp.feature.github.details.presentation

import android.content.Context
import ru.spitchenko.githubapp.R
import ru.spitchenko.githubapp.component.binderadapter.BindingClass
import ru.spitchenko.githubapp.feature.github.details.presentation.model.AuthorUiModel
import ru.spitchenko.githubapp.feature.github.details.presentation.model.DescriptionUiModel
import ru.spitchenko.githubapp.feature.github.domain.model.Repository
import java.text.SimpleDateFormat
import java.util.*

object DetailsConverter {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)

    fun convert(repository: Repository, context: Context): List<BindingClass> {

        val author = AuthorUiModel(
            name = repository.author.login,
            avatar = repository.author.avatar
        )
        val description = DescriptionUiModel(
            title = context.getString(R.string.repository_description),
            description = repository.description
        )
        val forks = DescriptionUiModel(
            title = context.getString(R.string.repository_forks),
            description = repository.forks.toString()
        )
        val stars = DescriptionUiModel(
            title = context.getString(R.string.repository_stars),
            description = repository.stars.toString()
        )
        val creationDate = DescriptionUiModel(
            title = context.getString(R.string.repository_creation_date),
            description = dateFormat.format(Date(repository.creationDate))
        )

        return listOf(author, description, forks, stars, creationDate)
    }
}