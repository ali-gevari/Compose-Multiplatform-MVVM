package org.movies.kmp.details.presentation

import org.movies.kmp.details.domain.model.Details

data class DetailsViewState(
    val isLoading: Boolean = false,
    val details: Details = Details(),
    val error: String? = null
)