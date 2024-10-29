package org.movies.kmp.search.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.movies.kmp.search.data.model.mapToSearchProgramList
import org.movies.kmp.search.data.remote.SearchApi
import org.movies.kmp.search.domain.model.SearchProgram
import org.movies.kmp.search.domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val searchApi: SearchApi
) : SearchRepository {

    override fun searchPrograms(query: String): Flow<List<SearchProgram>> = flow {
        val movies = searchApi.searchMovies(query)
            .allMovies.mapToSearchProgramList()
        val shows = searchApi.searchShows(query)
            .allShows.mapToSearchProgramList()

        val allSearchPrograms = mutableListOf<SearchProgram>().apply {
            addAll(movies)
            addAll(shows)
        }
        emit(allSearchPrograms)
    }
}