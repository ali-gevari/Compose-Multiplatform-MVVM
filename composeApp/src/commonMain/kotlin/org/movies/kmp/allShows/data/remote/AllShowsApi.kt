package org.movies.kmp.allShows.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.encodedPath
import org.movies.kmp.allShows.data.model.AllShowsDto

class AllShowsApi(
    private val client: HttpClient
) {
    suspend fun getAllShows(): AllShowsDto {
        return client.get {
            url {
                encodedPath = "trending/tv/day"
            }
        }.body()
    }
}