package org.movies.kmp.details.domain.repository

import kotlinx.coroutines.flow.Flow
import org.movies.kmp.details.domain.model.Details
import org.movies.kmp.util.ProgramType

interface DetailsRepository {
    fun getDetails(
        programId: Int,
        programType: ProgramType
    ): Flow<Details>
}