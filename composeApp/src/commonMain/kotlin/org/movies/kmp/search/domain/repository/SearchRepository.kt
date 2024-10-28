package org.movies.kmp.search.domain.repository

import kotlinx.coroutines.flow.Flow
import org.movies.kmp.search.domain.model.SearchProgram

interface SearchRepository {
    fun searchPrograms(query: String): Flow<List<SearchProgram>>
}