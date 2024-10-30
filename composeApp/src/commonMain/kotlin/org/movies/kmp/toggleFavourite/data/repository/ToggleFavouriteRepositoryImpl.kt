package org.movies.kmp.toggleFavourite.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.movies.kmp.toggleFavourite.data.model.ToggleFavouriteBody
import org.movies.kmp.toggleFavourite.data.model.mapToggleFavourite
import org.movies.kmp.toggleFavourite.data.remote.ToggleFavouriteApi
import org.movies.kmp.toggleFavourite.domain.model.ToggleFavourite
import org.movies.kmp.toggleFavourite.domain.repository.ToggleFavouriteRepository
import org.movies.kmp.util.ProgramType

class ToggleFavouriteRepositoryImpl(
    private val toggleFavouriteApi: ToggleFavouriteApi
) : ToggleFavouriteRepository {

    override fun toggleFavourite(
        programId: Int,
        programType: ProgramType,
        isFavourite: Boolean
    ): Flow<ToggleFavourite> = flow {
        val toggleFavouriteBody = ToggleFavouriteBody(
            id = programId,
            type = programType.type.lowercase(),
            favorite = isFavourite
        )
        val data = toggleFavouriteApi
            .toggleFavourite(toggleFavouriteBody)
            .mapToggleFavourite()
        emit(data)
    }
}