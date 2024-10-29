package org.movies.kmp.credits.domain.repository

import kotlinx.coroutines.flow.Flow
import org.movies.kmp.credits.domain.model.Credit
import org.movies.kmp.util.ProgramType

interface CreditsRepository {
    fun getCredits(
        programId: Int,
        programType: ProgramType
    ): Flow<Credit>
}