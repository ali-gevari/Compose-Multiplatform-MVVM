package org.movies.kmp.allMovies.domain.repository

import kotlinx.coroutines.flow.Flow
import org.movies.kmp.allMovies.domain.model.MovieProgram

interface AllMoviesRepository {
    fun getAllMovies(): Flow<List<MovieProgram>>
}