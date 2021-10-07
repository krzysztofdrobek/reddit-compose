package eu.krzysztofdrobek.reddit.feature.home

import androidx.navigation.compose.composable
import eu.krzysztofdrobek.reddit.navigation.NavigationModule
import eu.krzysztofdrobek.reddit.navigation.direction.HomeDirections

val homeNavigationModule = NavigationModule {
    composable(HomeDirections.dashboardRoute) {
        HomeScreen()
    }
}