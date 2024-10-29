package org.movies.kmp.details.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.encodedPath
import org.movies.kmp.details.data.model.DetailsDto

class DetailsApi(
    private val client: HttpClient
) {
    suspend fun getMovieDetails(programId: Int): DetailsDto {
        return client.get {
            url {
                encodedPath = "movie/$programId"
            }
        }.body()
    }
    suspend fun getShowDetails(programId: Int): DetailsDto {
        return client.get {
            url {
                encodedPath = "tv/$programId"
            }
        }.body()
    }
}