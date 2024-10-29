package org.movies.kmp.details.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailsDto(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String? = null,
    @SerialName("title") val title: String? = null,
    @SerialName("overview") val overview: String,
    @SerialName("poster_path") val posterPath: String,
    @SerialName("adult") val adult: Boolean,
    @SerialName("backdrop_path") val backdropImage: String,
    @SerialName("genres") val genres: List<GenreDto>,
    @SerialName("production_companies") val productionCompanies: List<ProductionCompanyDto>,
    @SerialName("status") val status: String,
    )

@Serializable
data class GenreDto(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String
)

@Serializable
data class ProductionCompanyDto(
    @SerialName("name") val name: String,
    @SerialName("logo_path") val logoPath: String?
)