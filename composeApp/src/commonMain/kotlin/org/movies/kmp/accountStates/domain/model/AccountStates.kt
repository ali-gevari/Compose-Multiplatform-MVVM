package org.movies.kmp.accountStates.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class AccountStates(
    val id: Int,
    val favorite: Boolean = false,
    val rated: Boolean = false,
    val watchlist: Boolean = false
)