package org.movies.kmp.credits.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.movies.kmp.credits.data.model.mapToCredit
import org.movies.kmp.credits.data.remote.CreditsApi
import org.movies.kmp.credits.domain.model.Credit
import org.movies.kmp.credits.domain.repository.CreditsRepository
import org.movies.kmp.util.ProgramType

class CreditsRepositoryImpl(
    private val creditsApi: CreditsApi,
) : CreditsRepository {

    override fun getCredits(
        programId: Int,
        programType: ProgramType
    ): Flow<Credit> = flow {
        when (programType) {
            ProgramType.TV -> {
                val data = creditsApi.getShowCredits(programId).mapToCredit()
                emit(data)
            }

            ProgramType.Movie -> {
                val data = creditsApi.getMovieCredits(programId).mapToCredit()
                emit(data)
            }

            ProgramType.Unknown -> {}
        }
    }
}