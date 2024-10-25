package org.movies.kmp.allMovies.presentation

import org.movies.kmp.allMovies.domain.model.MovieProgram

data class AllMoviesViewState(
    val isLoading: Boolean = false,
    val moviePrograms: List<MovieProgram> = emptyList(),
    val error: String? = null
)