package org.movies.kmp.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.movies.kmp.navigation.Destination

@Composable
fun AppBottomBar(
    allScreens: List<Destination>,
    onTabSelected: (Destination) -> Unit,
    currentScreen: Any
) {
    Surface(
        Modifier.height(86.dp)
    ) {
        NavigationBar(modifier = Modifier.fillMaxWidth()) {
            allScreens.forEach { destination ->
                NavigationBarItem(
                    selected = currentScreen == destination,
                    onClick = { onTabSelected(destination) },
                    icon = {
                        Icon(
                            imageVector = destination.icon,
                            contentDescription = destination.route
                        )
                    }
                )
            }
        }
    }
}