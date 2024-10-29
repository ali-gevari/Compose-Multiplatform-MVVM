package org.movies.kmp.credits.di

import org.koin.dsl.module
import org.movies.kmp.credits.data.remote.CreditsApi
import org.movies.kmp.credits.data.repository.CreditsRepositoryImpl
import org.movies.kmp.credits.domain.repository.CreditsRepository
import org.movies.kmp.credits.domain.useCase.GetCreditsUseCase

val creditsModules = module {
    single { CreditsApi(get()) }
    single<CreditsRepository> { CreditsRepositoryImpl(creditsApi = get()) }
    single { GetCreditsUseCase(get()) }
}