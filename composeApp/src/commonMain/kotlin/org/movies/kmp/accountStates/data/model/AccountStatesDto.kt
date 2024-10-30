package org.movies.kmp.accountStates.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountStatesDto(
    @SerialName("id") val id: Int,
    @SerialName("favorite") val favorite: Boolean,
    @SerialName("rated") val rated: Boolean,
    @SerialName("watchlist") val watchlist: Boolean
)