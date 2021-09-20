package eu.krzysztofdrobek.reddit.feature.postdetails

import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import eu.krzysztofdrobek.reddit.navigation.FeatureDirections
import eu.krzysztofdrobek.reddit.navigation.NavigationModule
import eu.krzysztofdrobek.reddit.navigation.PostDetailsDirections

val postDetailsNavigationModule = NavigationModule {
    navigation(
        startDestination = PostDetailsDirections.details.route,
        route = FeatureDirections.postDetails.route
    ) {
        composable(PostDetailsDirections.details.route) { PostDetailsScreen() }
        composable(PostDetailsDirections.share.route) { PostDetailsShareScreen() }
    }
}