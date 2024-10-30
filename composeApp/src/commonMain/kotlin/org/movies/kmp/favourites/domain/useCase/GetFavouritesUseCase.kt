package org.movies.kmp.favourites.domain.useCase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import org.movies.kmp.favourites.domain.model.FavouriteProgram
import org.movies.kmp.favourites.domain.repository.FavouritesRepository

class GetFavouritesUseCase(
    private val favouritesRepository: FavouritesRepository
) {
    operator fun invoke(): Flow<List<FavouriteProgram>> =
        favouritesRepository.getFavourites()
            .flowOn(Dispatchers.IO)
}