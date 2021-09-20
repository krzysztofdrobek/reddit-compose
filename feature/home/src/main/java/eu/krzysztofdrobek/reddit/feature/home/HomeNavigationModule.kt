package eu.krzysztofdrobek.reddit.feature.home

import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import eu.krzysztofdrobek.reddit.navigation.FeatureDirections
import eu.krzysztofdrobek.reddit.navigation.HomeDirections
import eu.krzysztofdrobek.reddit.navigation.NavigationModule

val homeNavigationModule = NavigationModule {
    navigation(
        startDestination = HomeDirections.frontPage.route,
        route = FeatureDirections.home.route
    ) {
        composable(HomeDirections.frontPage.route) { HomeScreen(HomeSection.FrontPage) }
        composable(HomeDirections.profile.route) { HomeScreen(HomeSection.Profile) }
        composable(HomeDirections.search.route) { HomeScreen(HomeSection.Search) }
        composable(HomeDirections.notifications.route) { HomeScreen(HomeSection.Notifications) }
    }
}