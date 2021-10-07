package eu.krzysztofdrobek.reddit.navigation.direction

import androidx.navigation.NavType
import androidx.navigation.navArgument
import eu.krzysztofdrobek.reddit.navigation.NavigationCommand

object PostDirections {
    private const val KEY_ROUTE_DETAILS = "postDetails"
    private const val KEY_ROUTE_SHARE = "postShare"

    const val PARAM_POST_ID = "postId"

    const val detailsRoute = "$KEY_ROUTE_DETAILS/{$PARAM_POST_ID}"
    const val shareRoute = "$KEY_ROUTE_SHARE/{$PARAM_POST_ID}"

    fun details(postId: String? = null) = object : NavigationCommand {
        override val destination = "$KEY_ROUTE_DETAILS/$postId"
        override val arguments = listOf(navArgument(PARAM_POST_ID) { type = NavType.StringType })
    }

    fun share(postId: String? = null) = object : NavigationCommand {
        override val destination = "$KEY_ROUTE_SHARE/$postId"
        override val arguments = listOf(navArgument(PARAM_POST_ID) { type = NavType.StringType })
    }
}