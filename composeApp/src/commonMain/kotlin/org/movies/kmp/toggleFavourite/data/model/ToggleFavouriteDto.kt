package org.movies.kmp.toggleFavourite.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ToggleFavouriteDto(
    @SerialName("success") val success: Boolean,
    @SerialName("status_message") val message: String
)