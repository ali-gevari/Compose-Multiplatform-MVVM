package org.movies.kmp.credits.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreditDto(
    @SerialName("cast") val cast: List<CastDto>,
    @SerialName("crew") val crew: List<CrewDto>,
)
@Serializable
data class CastDto(
    @SerialName("id") val id: Int,
    @SerialName("original_name") val originalName: String,
    @SerialName("profile_path") val profilePath: String? = null
)
@Serializable
data class CrewDto(
    @SerialName("id") val id: Int,
    @SerialName("original_name") val originalName: String,
    @SerialName("profile_path") val profilePath: String? = null
)