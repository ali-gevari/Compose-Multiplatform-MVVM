package org.movies.kmp.toggleFavourite.domain.useCase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import org.movies.kmp.toggleFavourite.domain.model.ToggleFavourite
import org.movies.kmp.toggleFavourite.domain.repository.ToggleFavouriteRepository
import org.movies.kmp.util.ProgramType

class ToggleFavouriteUseCase(
    private val toggleFavouriteRepository: ToggleFavouriteRepository
) {
    operator fun invoke(
        programId: Int,
        programType: ProgramType,
        isFavourite: Boolean
    ): Flow<ToggleFavourite> =
        toggleFavouriteRepository.toggleFavourite(programId, programType, isFavourite)
            .flowOn(Dispatchers.IO)
}