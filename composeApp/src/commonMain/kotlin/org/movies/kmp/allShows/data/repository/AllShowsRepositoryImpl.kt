package org.movies.kmp.allShows.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.movies.kmp.allShows.data.model.mapList
import org.movies.kmp.allShows.data.remote.AllShowsApi
import org.movies.kmp.allShows.domain.model.ShowProgram
import org.movies.kmp.allShows.domain.repository.AllShowsRepository

class AllShowsRepositoryImpl(
    private val allShowsApi: AllShowsApi
) : AllShowsRepository {

    override fun getAllShows(): Flow<List<ShowProgram>> = flow {
        val data = allShowsApi.getAllShows().allShows.mapList()
        emit(data)
    }
}