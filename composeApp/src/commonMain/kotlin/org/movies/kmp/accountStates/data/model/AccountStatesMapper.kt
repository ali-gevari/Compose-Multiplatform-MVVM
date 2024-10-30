package org.movies.kmp.accountStates.data.model

import org.movies.kmp.accountStates.domain.model.AccountStates

fun AccountStatesDto.mapToAccountStates() = AccountStates(
    id = this.id,
    rated = this.rated,
    favorite = this.favorite,
    watchlist = this.watchlist
)