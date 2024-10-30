package org.movies.kmp.toggleFavourite.data.model

import org.movies.kmp.toggleFavourite.domain.model.ToggleFavourite

fun ToggleFavouriteDto.mapToggleFavourite(): ToggleFavourite = ToggleFavourite(
    success = this.success,
    message = this.message
)