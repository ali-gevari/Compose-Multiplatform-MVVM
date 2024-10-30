package org.movies.kmp.toggleFavourite.di

import org.koin.dsl.module
import org.movies.kmp.toggleFavourite.data.remote.ToggleFavouriteApi
import org.movies.kmp.toggleFavourite.data.repository.ToggleFavouriteRepositoryImpl
import org.movies.kmp.toggleFavourite.domain.repository.ToggleFavouriteRepository
import org.movies.kmp.toggleFavourite.domain.useCase.ToggleFavouriteUseCase

val toggleFavouriteModules = module {
    single { ToggleFavouriteApi(get()) }
    single<ToggleFavouriteRepository> { ToggleFavouriteRepositoryImpl(toggleFavouriteApi = get()) }
    single { ToggleFavouriteUseCase(get()) }
}