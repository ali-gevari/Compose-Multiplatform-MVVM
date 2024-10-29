package org.movies.kmp.credits.presentation

import org.movies.kmp.credits.domain.model.Credit

data class CreditsViewState(
    val isLoading: Boolean = false,
    val credit: Credit = Credit(emptyList(), emptyList()),
    val error: String? = null
)