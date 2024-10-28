package org.movies.kmp.allShows.domain.repository

import kotlinx.coroutines.flow.Flow
import org.movies.kmp.allShows.domain.model.ShowProgram

interface AllShowsRepository {
    fun getAllShows(): Flow<List<ShowProgram>>
}