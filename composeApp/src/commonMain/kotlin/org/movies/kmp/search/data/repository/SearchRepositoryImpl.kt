package org.movies.kmp.search.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.movies.kmp.search.data.model.mapMovieToSearchProgramList
import org.movies.kmp.search.data.model.mapShowToSearchProgramList
import org.movies.kmp.search.data.remote.SearchApi
import org.movies.kmp.search.domain.model.SearchProgram
import org.movies.kmp.search.domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val searchApi: SearchApi
) : SearchRepository {

    override fun searchPrograms(query: String): Flow<List<SearchProgram>> = flow {
        val movies = searchApi.searchMovies(query)
            .allMovies.mapMovieToSearchProgramList()
        val shows = searchApi.searchShows(query)
            .allShows.mapShowToSearchProgramList()

        val allSearchPrograms = mutableListOf<SearchProgram>().apply {
            addAll(movies)
            addAll(shows)
        }
        emit(allSearchPrograms)
    }
}