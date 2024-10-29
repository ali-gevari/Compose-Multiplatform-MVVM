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
import org.movies.kmp.details.domain.useCase.GetDetailsUseCase
import org.movies.kmp.util.ProgramType

class DetailsViewModel(
    private val getDetailsUseCase: GetDetailsUseCase,
) : ViewModel() {

    private val _detailsState = MutableStateFlow(DetailsViewState())
    val detailsState = _detailsState.asStateFlow()

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
                }
        }
    }
}