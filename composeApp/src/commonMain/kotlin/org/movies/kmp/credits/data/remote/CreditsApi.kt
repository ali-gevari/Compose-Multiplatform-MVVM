package org.movies.kmp.credits.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.encodedPath
import org.movies.kmp.credits.data.model.CreditDto

class CreditsApi(
    private val client: HttpClient
) {
    suspend fun getMovieCredits(programId: Int): CreditDto {
        return client.get {
            url {
                encodedPath = "movie/$programId/credits"
            }
        }.body()
    }
    suspend fun getShowCredits(programId: Int): CreditDto {
        return client.get {
            url {
                encodedPath = "tv/$programId/credits"
            }
        }.body()
    }
}