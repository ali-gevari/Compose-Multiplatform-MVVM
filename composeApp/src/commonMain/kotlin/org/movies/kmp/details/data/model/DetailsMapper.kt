package org.movies.kmp.details.data.model

import org.movies.kmp.details.domain.model.Details
import org.movies.kmp.details.domain.model.ProductionCompany
import org.movies.kmp.util.Constant.IMAGE_BASE_URL

fun DetailsDto.mapDetails(): Details = Details(
    id = this.id,
    title = this.title ?: this.name ?: "NO TITLE",
    image = IMAGE_BASE_URL + this.posterPath,
    overview = this.overview,
    adults = this.adult,
    backdrop = IMAGE_BASE_URL + this.backdropImage,
    status = this.status,
    genres = this.genres.map { it.name },
    productionCompany = this.productionCompanies.map {
        ProductionCompany(
            name = it.name,
            image = IMAGE_BASE_URL + it.logoPath
        )
    }
)
