package org.movies.kmp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.movies.kmp.compose.OverviewScreen
import org.movies.kmp.details.presentation.DetailsScreen
import org.movies.kmp.favourites.presentation.FavouritesScreen
import org.movies.kmp.util.ProgramType
import org.movies.kmp.util.navigateToDetails

@Composable
fun AppNavHost(
    navController: NavHostController,
    padding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Overview.route
    ) {
        composable(route = Overview.route) {
            OverviewScreen(
                padding,
                onSearchItemClick = { program ->
                    navController.navigateToDetails(program.id, program.programType.type)
                },
                onMovieItemClick = { program ->
                    navController.navigateToDetails(program.id, ProgramType.Movie.type)
                },
                onShowItemClick = { program ->
                    navController.navigateToDetails(program.id, ProgramType.TV.type)
                }
            )
        }

        composable(route = Favourites.route) {
            FavouritesScreen(
                padding,
                onItemClick = { program ->
                    navController.navigateToDetails(program.id, program.programType.type)
                }
            )
        }

        composable(
            route = Details.routeWithArgs,
            arguments = Details.arguments
        ) { navBackStackEntry ->
            val programId =
                navBackStackEntry.arguments?.getInt(Details.PROGRAM_ID)
            val programType =
                navBackStackEntry.arguments?.getString(Details.PROGRAM_TYPE)
            DetailsScreen(navController, programId, programType)
        }
    }
}