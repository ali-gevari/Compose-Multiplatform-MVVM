package org.movies.kmp.accountStates.di

import org.koin.dsl.module
import org.movies.kmp.accountStates.data.remote.AccountStatesApi
import org.movies.kmp.accountStates.data.repository.AccountStatesRepositoryImpl
import org.movies.kmp.accountStates.domain.repository.AccountStatesRepository
import org.movies.kmp.accountStates.domain.useCase.GetAccountStatesUseCase

val accountStatesModules = module {
    single { AccountStatesApi(get()) }
    single<AccountStatesRepository> { AccountStatesRepositoryImpl(accountStatesApi = get()) }
    single { GetAccountStatesUseCase(get()) }
}