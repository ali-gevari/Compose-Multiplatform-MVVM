package org.movies.kmp.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.movies.kmp.allMovies.domain.model.MovieProgram
import org.movies.kmp.allMovies.presentation.AllMoviesScreen
import org.movies.kmp.allShows.domain.model.ShowProgram
import org.movies.kmp.allShows.presentation.AllShowsScreen
import org.movies.kmp.search.domain.model.SearchProgram
import org.movies.kmp.search.presentation.SearchScreen

@Composable
fun OverviewScreen(
    padding: PaddingValues,
    onSearchItemClick: (SearchProgram) -> Unit,
    onMovieItemClick: (MovieProgram) -> Unit,
    onShowItemClick: (ShowProgram) -> Unit

) {
    Column(
        modifier = Modifier.padding(
            top = padding.calculateTopPadding()
        )
    ) {
        SearchScreen(onItemClick = onSearchItemClick)
        AllMoviesScreen(onItemClick = onMovieItemClick)
        AllShowsScreen(onItemClick = onShowItemClick)
    }
}