package org.movies.kmp

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.movies.kmp.allMovies.presentation.AllMoviesScreen

@Composable
fun App() {
    MaterialTheme {
        AllMoviesScreen {}
    }
}