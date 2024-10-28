package org.movies.kmp.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.movies.kmp.allMovies.domain.model.MovieProgram
import org.movies.kmp.allMovies.presentation.AllMoviesScreen
import org.movies.kmp.allShows.domain.model.ShowProgram
import org.movies.kmp.allShows.presentation.AllShowsScreen
import org.movies.kmp.search.domain.model.SearchProgram
import org.movies.kmp.search.presentation.SearchScreen

@Composable
fun OverviewScreen(
    onSearchItemClick: (SearchProgram) -> Unit,
    onMovieItemClick: (MovieProgram) -> Unit,
    onShowItemClick: (ShowProgram) -> Unit

) {
    Column {
        Spacer(Modifier.height(16.dp))
        SearchScreen(onItemClick = onSearchItemClick)
        AllMoviesScreen(onItemClick = onMovieItemClick)
        AllShowsScreen(onItemClick = onShowItemClick)
    }
}