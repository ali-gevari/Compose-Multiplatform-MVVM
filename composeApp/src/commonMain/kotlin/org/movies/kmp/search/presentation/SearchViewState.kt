package org.movies.kmp.search.presentation

import org.movies.kmp.search.domain.model.SearchProgram

data class SearchViewState(
    val isLoading: Boolean = false,
    val searchPrograms: List<SearchProgram> = emptyList(),
    val error: String? = null
)