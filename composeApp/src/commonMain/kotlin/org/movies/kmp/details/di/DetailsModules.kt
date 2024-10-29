package org.movies.kmp.details.di

import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.movies.kmp.details.data.remote.DetailsApi
import org.movies.kmp.details.data.repository.DetailsRepositoryImpl
import org.movies.kmp.details.domain.repository.DetailsRepository
import org.movies.kmp.details.domain.useCase.GetDetailsUseCase
import org.movies.kmp.details.presentation.DetailsViewModel

val detailsModules = module {
    single { DetailsApi(get()) }
    single<DetailsRepository> { DetailsRepositoryImpl(detailsApi = get()) }
    single { GetDetailsUseCase(get()) }
    viewModel { DetailsViewModel(get(), get()) }
}