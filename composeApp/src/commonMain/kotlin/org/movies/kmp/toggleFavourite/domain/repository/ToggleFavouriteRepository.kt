package org.movies.kmp.toggleFavourite.domain.repository

import kotlinx.coroutines.flow.Flow
import org.movies.kmp.toggleFavourite.domain.model.ToggleFavourite
import org.movies.kmp.util.ProgramType

interface ToggleFavouriteRepository {
    fun toggleFavourite(
        programId: Int,
        programType: ProgramType,
        isFavourite: Boolean
    ): Flow<ToggleFavourite>
}