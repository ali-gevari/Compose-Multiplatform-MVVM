package org.movies.kmp.favourites.di

import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.movies.kmp.favourites.data.remote.FavouritesApi
import org.movies.kmp.favourites.data.repository.FavouritesRepositoryImpl
import org.movies.kmp.favourites.domain.repository.FavouritesRepository
import org.movies.kmp.favourites.domain.useCase.GetFavouritesUseCase
import org.movies.kmp.favourites.presentation.FavouritesViewModel

val favouritesModules = module {
    single { FavouritesApi(get()) }
    single<FavouritesRepository> { FavouritesRepositoryImpl(favouritesApi = get()) }
    single { GetFavouritesUseCase(get()) }
    viewModel { FavouritesViewModel(get()) }
}