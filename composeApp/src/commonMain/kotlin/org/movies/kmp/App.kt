package org.movies.kmp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.movies.kmp.compose.AppBottomBar
import org.movies.kmp.navigation.AppNavHost
import org.movies.kmp.navigation.Overview
import org.movies.kmp.navigation.bottomBarScreens
import org.movies.kmp.util.navigateSingleTopTo

@Composable
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen =
            bottomBarScreens.find { it.route == currentDestination?.route }
                ?: Overview
        Scaffold(
            bottomBar = {
                AppBottomBar(
                    allScreens = bottomBarScreens,
                    onTabSelected = { newScreen ->
                        navController.navigateSingleTopTo(newScreen.route)
                    },
                    currentScreen = currentScreen,
                )
            }
        ) { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        bottom = padding.calculateBottomPadding(),
                        top = padding.calculateTopPadding()
                    )
            ) {
                AppNavHost(navController = navController)
            }
        }
    }
}