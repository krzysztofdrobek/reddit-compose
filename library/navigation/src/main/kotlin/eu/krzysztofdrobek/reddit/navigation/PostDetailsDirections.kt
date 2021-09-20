package eu.krzysztofdrobek.reddit.navigation

object PostDetailsDirections {
    val details = object : NavigationCommand {
        override val route: String = "post_details"
    }

    val share = object : NavigationCommand {
        override val route: String = "post_details_share"
    }
}
