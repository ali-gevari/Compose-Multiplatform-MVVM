package org.movies.kmp.accountStates.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.encodedPath
import org.movies.kmp.accountStates.data.model.AccountStatesDto

class AccountStatesApi(
    private val client: HttpClient
) {
    suspend fun getMovieAccountStates(programId: Int): AccountStatesDto {
        return client.get {
            url {
                encodedPath = "movie/$programId/account_states"
            }
        }.body()
    }
    suspend fun getShowAccountStates(programId: Int): AccountStatesDto {
        return client.get {
            url {
                encodedPath = "tv/$programId/account_states"
            }
        }.body()
    }
}