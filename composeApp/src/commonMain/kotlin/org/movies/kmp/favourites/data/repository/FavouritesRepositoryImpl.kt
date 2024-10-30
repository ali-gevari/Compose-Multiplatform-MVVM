package org.movies.kmp.favourites.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.movies.kmp.favourites.data.model.mapMoviesToFavouriteProgram
import org.movies.kmp.favourites.data.model.mapShowsToFavouriteProgram
import org.movies.kmp.favourites.data.remote.FavouritesApi
import org.movies.kmp.favourites.domain.model.FavouriteProgram
import org.movies.kmp.favourites.domain.repository.FavouritesRepository

class FavouritesRepositoryImpl(
    private val favouritesApi: FavouritesApi
) : FavouritesRepository {

    override fun getFavourites(): Flow<List<FavouriteProgram>> = flow {
        val favouriteMovies = favouritesApi.getFavouriteMovies()
            .allMovies.mapMoviesToFavouriteProgram()
        val favouriteShows = favouritesApi.getFavouriteShows()
            .allShows.mapShowsToFavouriteProgram()

        val allFavouritePrograms = mutableListOf<FavouriteProgram>().apply {
            addAll(favouriteMovies)
            addAll(favouriteShows)
        }
        emit(allFavouritePrograms)
    }
}