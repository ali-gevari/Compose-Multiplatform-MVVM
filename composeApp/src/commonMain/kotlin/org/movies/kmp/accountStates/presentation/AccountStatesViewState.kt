package org.movies.kmp.accountStates.presentation

data class AccountStatesViewState(
    val isLoading: Boolean = false,
    val isFavourite: Boolean = false,
    val error: String? = null
)