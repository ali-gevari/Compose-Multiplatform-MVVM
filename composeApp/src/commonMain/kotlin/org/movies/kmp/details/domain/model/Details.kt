package org.movies.kmp.details.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Details(
    val id: Int = 0,
    val title: String = "Title",
    val overview: String = "Overview",
    val image: String = "ImagePath",
    val backdrop: String = "Backdrop",
    val adults: Boolean = true,
    val genres: List<String> = emptyList(),
    val productionCompany: List<ProductionCompany> = emptyList(),
    val status: String = "Status"

)

@Serializable
data class ProductionCompany(
    val name: String,
    val image: String
)