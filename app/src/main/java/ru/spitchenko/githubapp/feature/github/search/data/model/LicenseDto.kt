package ru.spitchenko.githubapp.feature.github.search.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LicenseDto(
    val key: String?,
    val name: String?,
    @SerialName("node_id")
    val nodeId: String?,
    @SerialName("spdx_id")
    val spdxId: String?,
    val url: String?
)