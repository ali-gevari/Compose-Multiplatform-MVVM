package org.movies.kmp.allMovies.domain.useCase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import org.movies.kmp.allMovies.domain.model.MovieProgram
import org.movies.kmp.allMovies.domain.repository.AllMoviesRepository

class GetAllMoviesUseCase (
    private val allMoviesRepository: AllMoviesRepository
) {
    operator fun invoke(): Flow<List<MovieProgram>> = allMoviesRepository.getAllMovies()
        .flowOn(Dispatchers.IO)
}