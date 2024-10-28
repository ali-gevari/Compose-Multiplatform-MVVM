package org.movies.kmp

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.movies.kmp.compose.OverviewScreen

@Composable
fun App() {
    MaterialTheme {
        OverviewScreen(
            onSearchItemClick = {},
            onMovieItemClick = {},
            onShowItemClick = {}
        )
    }
}