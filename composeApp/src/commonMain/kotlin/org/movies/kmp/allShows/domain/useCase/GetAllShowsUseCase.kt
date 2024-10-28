package org.movies.kmp.allShows.domain.useCase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import org.movies.kmp.allShows.domain.model.ShowProgram
import org.movies.kmp.allShows.domain.repository.AllShowsRepository

class GetAllShowsUseCase (
    private val allShowsRepository: AllShowsRepository
) {
    operator fun invoke(): Flow<List<ShowProgram>> = allShowsRepository.getAllShows()
        .flowOn(Dispatchers.IO)
}