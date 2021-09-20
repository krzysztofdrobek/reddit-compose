package eu.krzysztofdrobek.reddit.navigation

object FeatureDirections {
    val home = object : NavigationCommand {
        override val route: String = "home"
    }
    val postDetails = object : NavigationCommand {
        override val route: String = "postDetails"
    }
}
