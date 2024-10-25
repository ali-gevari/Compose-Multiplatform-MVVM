package org.movies.kmp.allMovies.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.movies.kmp.allMovies.data.model.mapList
import org.movies.kmp.allMovies.data.remote.AllMoviesApi
import org.movies.kmp.allMovies.domain.model.MovieProgram
import org.movies.kmp.allMovies.domain.repository.AllMoviesRepository

class AllMoviesRepositoryImpl(
    private val allMoviesApi: AllMoviesApi
) : AllMoviesRepository {

    override fun getAllMovies(): Flow<List<MovieProgram>> = flow {
        val data = allMoviesApi.getAllMovies().allMovies.mapList()
        emit(data)
    }
}