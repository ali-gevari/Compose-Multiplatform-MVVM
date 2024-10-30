package org.movies.kmp.favourites.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.encodedPath
import org.movies.kmp.allMovies.data.model.AllMoviesDto
import org.movies.kmp.allShows.data.model.AllShowsDto

class FavouritesApi(
    private val client: HttpClient
) {
    suspend fun getFavouriteMovies(): AllMoviesDto {
        return client.get {
            url {
                encodedPath = "account/{account_id}/favorite/movies"
            }
        }.body()
    }
    suspend fun getFavouriteShows(): AllShowsDto {
        return client.get {
            url {
                encodedPath = "account/{account_id}/favorite/tv"
            }
        }.body()
    }
}