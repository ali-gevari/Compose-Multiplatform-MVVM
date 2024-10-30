package org.movies.kmp.toggleFavourite.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.contentType
import io.ktor.http.encodedPath
import org.movies.kmp.toggleFavourite.data.model.ToggleFavouriteBody
import org.movies.kmp.toggleFavourite.data.model.ToggleFavouriteDto

class ToggleFavouriteApi(
    private val client: HttpClient
) {
    suspend fun toggleFavourite(favoriteBody: ToggleFavouriteBody): ToggleFavouriteDto {
        return client.post {
            url {
                encodedPath = "account/{Your Account ID}/favorite"
            }
            contentType(io.ktor.http.ContentType.Application.Json)
            setBody(favoriteBody)
        }.body()
    }
}