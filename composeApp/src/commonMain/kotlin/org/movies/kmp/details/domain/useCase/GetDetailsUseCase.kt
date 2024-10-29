package org.movies.kmp.details.domain.useCase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import org.movies.kmp.details.domain.model.Details
import org.movies.kmp.details.domain.repository.DetailsRepository
import org.movies.kmp.util.ProgramType

class GetDetailsUseCase(
    private val detailsRepository: DetailsRepository
) {
    operator fun invoke(
        programId: Int,
        programType: ProgramType
    ): Flow<Details> =
        detailsRepository.getDetails(programId, programType)
            .flowOn(Dispatchers.IO)
}