package org.movies.kmp.accountStates.domain.useCase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import org.movies.kmp.accountStates.domain.model.AccountStates
import org.movies.kmp.accountStates.domain.repository.AccountStatesRepository
import org.movies.kmp.util.ProgramType

class GetAccountStatesUseCase(
    private val accountStatesRepository: AccountStatesRepository
) {
    operator fun invoke(
        programId: Int,
        programType: ProgramType
    ): Flow<AccountStates> =
        accountStatesRepository.getAccountStates(programId, programType)
            .flowOn(Dispatchers.IO)
}