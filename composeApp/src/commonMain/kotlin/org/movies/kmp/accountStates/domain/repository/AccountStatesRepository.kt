package org.movies.kmp.accountStates.domain.repository

import kotlinx.coroutines.flow.Flow
import org.movies.kmp.accountStates.domain.model.AccountStates
import org.movies.kmp.util.ProgramType

interface AccountStatesRepository {
    fun getAccountStates(
        programId: Int,
        programType: ProgramType
    ): Flow<AccountStates>
}