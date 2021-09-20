package eu.krzysztofdrobek.reddit.navigation

import androidx.navigation.NavOptions

object HomeDirections {
    val homeNavOptions = NavOptions
        .Builder()
        .setLaunchSingleTop(true)
        .setRestoreState(true)
        .setPopUpTo(FeatureDirections.home.route, true)
        .build()
    
    val frontPage = object : NavigationCommand {
        override val route: String = "frontPage"
        override val navOptions: NavOptions = homeNavOptions
    }

    val profile = object : NavigationCommand {
        override val route: String = "profile"
        override val navOptions: NavOptions = homeNavOptions
    }

    val search = object : NavigationCommand {
        override val route: String = "search"
        override val navOptions: NavOptions = homeNavOptions
    }

    val notifications = object : NavigationCommand {
        override val route: String = "notifications"
        override val navOptions: NavOptions = homeNavOptions
    }
}
