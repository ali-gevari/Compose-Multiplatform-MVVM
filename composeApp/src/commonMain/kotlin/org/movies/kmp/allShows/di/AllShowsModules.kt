package org.movies.kmp.allShows.di

import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.movies.kmp.allShows.data.remote.AllShowsApi
import org.movies.kmp.allShows.data.repository.AllShowsRepositoryImpl
import org.movies.kmp.allShows.domain.repository.AllShowsRepository
import org.movies.kmp.allShows.domain.useCase.GetAllShowsUseCase
import org.movies.kmp.allShows.presentation.AllShowsViewModel

val allShowsModules = module {
    single { AllShowsApi(get()) }
    single<AllShowsRepository> { AllShowsRepositoryImpl(allShowsApi = get()) }
    single { GetAllShowsUseCase(get()) }
    viewModel { AllShowsViewModel(get()) }
}