package org.movies.kmp.favourites.domain.repository

import kotlinx.coroutines.flow.Flow
import org.movies.kmp.favourites.domain.model.FavouriteProgram

interface FavouritesRepository {
    fun getFavourites(): Flow<List<FavouriteProgram>>
}