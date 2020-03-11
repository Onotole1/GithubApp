package ru.spitchenko.githubapp.feature.github.details.presentation.model

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import ru.spitchenko.githubapp.feature.github.domain.model.Author
import ru.spitchenko.githubapp.feature.github.domain.model.Repository
import ru.spitchenko.githubapp.feature.github.domain.model.SimpleRepository

data class RepositoryArgs(val repository: Repository) : Parcelable {
    constructor(parcel: Parcel) : this(
        SimpleRepository(
            id = parcel.readLong(),
            name = requireNotNull(parcel.readString()),
            author = Author(
                requireNotNull(parcel.readString()),
                parcel.readString()
            ),
            forks = parcel.readInt(),
            description = requireNotNull(parcel.readString()),
            stars = parcel.readInt(),
            creationDate = parcel.readLong()
        )
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(repository.id)
        parcel.writeString(repository.name)
        parcel.writeString(repository.author.login)
        parcel.writeString(repository.author.avatar)
        parcel.writeInt(repository.forks)
        parcel.writeString(repository.description)
        parcel.writeInt(repository.stars)
        parcel.writeLong(repository.creationDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RepositoryArgs> {
        override fun createFromParcel(parcel: Parcel): RepositoryArgs {
            return RepositoryArgs(parcel)
        }

        override fun newArray(size: Int): Array<RepositoryArgs?> {
            return arrayOfNulls(size)
        }
    }
}

private const val REPOSITORY_KEY = "REPOSITORY_KEY"
var Bundle.repositoryArgs: RepositoryArgs
    get() = requireNotNull(getParcelable(REPOSITORY_KEY))
    set(value) = putParcelable(REPOSITORY_KEY, value)