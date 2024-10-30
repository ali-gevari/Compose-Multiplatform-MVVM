package org.movies.kmp.favourites.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.movies.kmp.favourites.domain.useCase.GetFavouritesUseCase

class FavouritesViewModel(
    private val getFavouritesUseCase: GetFavouritesUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(FavouritesViewState())
    val state = _state.asStateFlow()

    init {
        getFavourites()
    }

    private fun getFavourites() {
        viewModelScope.launch {
            getFavouritesUseCase()
                .onStart {
                    _state.update {
                        it.copy(isLoading = true)
                    }
                }
                .catch { error ->
                    _state.update {
                        it.copy(error = error.message)
                    }
                }
                .onCompletion {
                    _state.update {
                        it.copy(isLoading = false)
                    }
                }
                .collect { allFavourites ->
                    _state.update {
                        it.copy(allFavourites = allFavourites)
                    }
                }
        }
    }
}