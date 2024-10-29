package org.movies.kmp.details.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.movies.kmp.details.data.model.mapDetails
import org.movies.kmp.details.data.remote.DetailsApi
import org.movies.kmp.details.domain.model.Details
import org.movies.kmp.details.domain.repository.DetailsRepository
import org.movies.kmp.util.ProgramType

class DetailsRepositoryImpl(
    private val detailsApi: DetailsApi
) : DetailsRepository {

    override fun getDetails(
        programId: Int,
        programType: ProgramType
    ): Flow<Details> = flow {
        when (programType) {
            ProgramType.TV -> {
                val data = detailsApi.getShowDetails(programId).mapDetails()
                emit(data)
            }

            ProgramType.Movie -> {
                val data = detailsApi.getMovieDetails(programId).mapDetails()
                emit(data)
            }

            ProgramType.Unknown -> {}
        }
    }
}