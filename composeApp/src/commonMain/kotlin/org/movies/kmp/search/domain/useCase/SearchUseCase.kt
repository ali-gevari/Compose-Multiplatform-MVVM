package org.movies.kmp.search.domain.useCase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import org.movies.kmp.search.domain.model.SearchProgram
import org.movies.kmp.search.domain.repository.SearchRepository

class SearchUseCase (
    private val searchRepository: SearchRepository
) {
    operator fun invoke(query: String): Flow<List<SearchProgram>> = searchRepository.searchPrograms(query)
        .flowOn(Dispatchers.IO)
}