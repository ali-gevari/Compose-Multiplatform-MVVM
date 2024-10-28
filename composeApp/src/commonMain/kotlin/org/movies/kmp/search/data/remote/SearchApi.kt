package org.movies.kmp.search.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.encodedPath
import org.movies.kmp.allMovies.data.model.AllMoviesDto
import org.movies.kmp.allShows.data.model.AllShowsDto

class SearchApi(
    private val client: HttpClient
) {
    suspend fun searchMovies(query: String): AllMoviesDto {
        return client.get {
            url {
                encodedPath = "search/movie"
                parameters.append("query", query)
            }
        }.body()
    }
    suspend fun searchShows(query: String): AllShowsDto {
        return client.get {
            url {
                encodedPath = "search/tv"
                parameters.append("query", query)
            }
        }.body()
    }
}