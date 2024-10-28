package org.movies.kmp.allShows.presentation

import org.movies.kmp.allShows.domain.model.ShowProgram

data class AllShowsViewState(
    val isLoading: Boolean = false,
    val showPrograms: List<ShowProgram> = emptyList(),
    val error: String? = null
)