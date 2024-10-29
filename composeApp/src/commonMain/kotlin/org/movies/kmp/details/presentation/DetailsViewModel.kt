package org.movies.kmp.details.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.movies.kmp.credits.domain.useCase.GetCreditsUseCase
import org.movies.kmp.credits.presentation.CreditsViewState
import org.movies.kmp.details.domain.useCase.GetDetailsUseCase
import org.movies.kmp.util.ProgramType

class DetailsViewModel(
    private val getDetailsUseCase: GetDetailsUseCase,
    private val getCreditsUseCase: GetCreditsUseCase,
) : ViewModel() {

    private val _detailsState = MutableStateFlow(DetailsViewState())
    val detailsState = _detailsState.asStateFlow()

    private val _creditsState = MutableStateFlow(CreditsViewState())
    val creditsState = _creditsState.asStateFlow()

    fun getDetails(programId: Int, programType: ProgramType) {
        viewModelScope.launch {
            getDetailsUseCase(programId, programType)
                .onStart {
                    _detailsState.update {
                        it.copy(isLoading = true)
                    }
                }
                .catch { error ->
                    _detailsState.update {
                        it.copy(error = error.message)
                    }
                }
                .onCompletion {
                    _detailsState.update {
                        it.copy(isLoading = false)
                    }
                }
                .collect { details ->
                    _detailsState.update {
                        it.copy(details = details)
                    }
                    getCredits(programId, programType)
                }
        }
    }

    private fun getCredits(programId: Int, programType: ProgramType) {
        viewModelScope.launch {
            getCreditsUseCase(programId, programType)
                .onStart {
                    _creditsState.update {
                        it.copy(isLoading = true)
                    }
                }
                .catch { error ->
                    _detailsState.update {
                        it.copy(error = error.message)
                    }
                }
                .onCompletion {
                    _creditsState.update {
                        it.copy(isLoading = false)
                    }
                }
                .collect { credits ->
                    _creditsState.update {
                        it.copy(credit = credits)
                    }
                }
        }
    }
}