package org.movies.kmp.toggleFavourite.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ToggleFavouriteBody(
    @SerialName("media_id") val id: Int,
    @SerialName("media_type") val type: String,
    @SerialName("favorite") val favorite: Boolean
)