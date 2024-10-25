package org.movies.kmp.allMovies.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.encodedPath
import org.movies.kmp.allMovies.data.model.AllMoviesDto

class AllMoviesApi(
    private val client: HttpClient
) {
    suspend fun getAllMovies(): AllMoviesDto {
        return client.get {
            url {
                encodedPath = "trending/movie/day"
            }
        }.body()
    }
}