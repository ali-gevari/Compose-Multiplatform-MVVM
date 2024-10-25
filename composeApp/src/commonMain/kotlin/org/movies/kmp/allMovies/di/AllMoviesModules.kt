package org.movies.kmp.allMovies.di

import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.movies.kmp.allMovies.data.remote.AllMoviesApi
import org.movies.kmp.allMovies.data.repository.AllMoviesRepositoryImpl
import org.movies.kmp.allMovies.domain.repository.AllMoviesRepository
import org.movies.kmp.allMovies.domain.useCase.GetAllMoviesUseCase
import org.movies.kmp.allMovies.presentation.AllMoviesViewModel

val allMoviesModules = module {
    single { AllMoviesApi(get()) }
    single<AllMoviesRepository> { AllMoviesRepositoryImpl(allMoviesApi = get()) }
    single { GetAllMoviesUseCase(get()) }
    viewModel { AllMoviesViewModel(get()) }
}