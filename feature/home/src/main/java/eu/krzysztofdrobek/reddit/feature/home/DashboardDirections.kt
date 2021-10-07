package eu.krzysztofdrobek.reddit.feature.home

import androidx.navigation.NavOptions
import eu.krzysztofdrobek.reddit.navigation.NavigationCommand

object DashboardDirections {

    object Route {
        const val frontPage = "frontPage"
        const val profile = "profile"
        const val search = "search"
        const val notifications = "notifications"
    }

    val homeNavOptions = NavOptions
        .Builder()
        .setPopUpTo(Route.frontPage, inclusive = false, saveState = true)
        .setLaunchSingleTop(true)
        .setRestoreState(true)
        .build()

    fun frontPage() = object : NavigationCommand {
        override val destination: String = Route.frontPage
        override val navOptions: NavOptions = homeNavOptions
    }

    fun profile() = object : NavigationCommand {
        override val destination: String = Route.profile
        override val navOptions: NavOptions = homeNavOptions
    }

    fun search() = object : NavigationCommand {
        override val destination: String = Route.search
        override val navOptions: NavOptions = homeNavOptions
    }

    fun notifications() = object : NavigationCommand {
        override val destination: String = Route.notifications
        override val navOptions: NavOptions = homeNavOptions
    }
}
