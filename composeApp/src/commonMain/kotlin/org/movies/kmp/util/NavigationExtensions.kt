package org.movies.kmp.util

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import org.movies.kmp.navigation.Details

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().route ?: return@navigate
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

fun NavHostController.navigateToDetails(programId: Int, programType: String) {
    this.navigateSingleTopTo("${Details.route}/$programId/$programType")
}