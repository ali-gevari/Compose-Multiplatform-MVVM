package org.movies.kmp.accountStates.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.movies.kmp.accountStates.data.model.mapToAccountStates
import org.movies.kmp.accountStates.data.remote.AccountStatesApi
import org.movies.kmp.accountStates.domain.model.AccountStates
import org.movies.kmp.accountStates.domain.repository.AccountStatesRepository
import org.movies.kmp.util.ProgramType

class AccountStatesRepositoryImpl(
    private val accountStatesApi: AccountStatesApi
) : AccountStatesRepository {

    override fun getAccountStates(
        programId: Int,
        programType: ProgramType
    ): Flow<AccountStates> = flow {
        when (programType) {
            ProgramType.TV -> {
                val data = accountStatesApi.getShowAccountStates(programId).mapToAccountStates()
                emit(data)
            }

            ProgramType.Movie -> {
                val data = accountStatesApi.getMovieAccountStates(programId).mapToAccountStates()
                emit(data)
            }

            ProgramType.Unknown -> {}
        }
    }
}