package org.movies.kmp.favourites.presentation

import org.movies.kmp.favourites.domain.model.FavouriteProgram

data class FavouritesViewState(
    val isLoading: Boolean = false,
    val allFavourites: List<FavouriteProgram> = emptyList(),
    val error: String? = null
)