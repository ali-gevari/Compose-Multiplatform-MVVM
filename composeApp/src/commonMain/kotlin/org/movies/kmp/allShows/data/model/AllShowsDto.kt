package org.movies.kmp.allShows.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AllShowsDto(
    @SerialName("results") val allShows: List<ShowDto>
)

@Serializable
data class ShowDto(
    @SerialName("id") val id: Int,
    @SerialName("original_name") val title: String,
    @SerialName("poster_path") val posterPath: String?
)