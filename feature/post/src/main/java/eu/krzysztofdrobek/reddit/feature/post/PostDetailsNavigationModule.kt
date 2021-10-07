package eu.krzysztofdrobek.reddit.feature.post

import androidx.navigation.compose.composable
import eu.krzysztofdrobek.reddit.feature.post.details.PostDetailsScreen
import eu.krzysztofdrobek.reddit.feature.post.share.PostDetailsShareScreen
import eu.krzysztofdrobek.reddit.navigation.NavigationModule
import eu.krzysztofdrobek.reddit.navigation.direction.PostDirections

val postNavigationModule = NavigationModule {
    composable(PostDirections.detailsRoute) {
        val postId = it.arguments?.getString(PostDirections.PARAM_POST_ID)
            ?: throw IllegalArgumentException()
        PostDetailsScreen(postId)
    }
    composable(PostDirections.shareRoute) {
        val postId = it.arguments?.getString(PostDirections.PARAM_POST_ID)
            ?: throw IllegalArgumentException()
        PostDetailsShareScreen(postId)
    }
}