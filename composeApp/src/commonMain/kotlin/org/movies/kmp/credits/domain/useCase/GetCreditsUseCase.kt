package org.movies.kmp.credits.domain.useCase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import org.movies.kmp.credits.domain.model.Credit
import org.movies.kmp.credits.domain.repository.CreditsRepository
import org.movies.kmp.util.ProgramType

class GetCreditsUseCase(
    private val creditsRepository: CreditsRepository
) {
    operator fun invoke(
        programId: Int,
        programType: ProgramType
    ): Flow<Credit> =
        creditsRepository.getCredits(programId, programType)
            .flowOn(Dispatchers.IO)
}