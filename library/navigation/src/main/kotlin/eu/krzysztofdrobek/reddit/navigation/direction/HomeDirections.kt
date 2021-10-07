package eu.krzysztofdrobek.reddit.navigation.direction

import androidx.navigation.NavOptions
import eu.krzysztofdrobek.reddit.navigation.NavigationCommand

object HomeDirections {
    const val dashboardRoute = "dashboard"

    fun dashboard() = object : NavigationCommand {
        override val destination = dashboardRoute
        override val navOptions = NavOptions.Builder()
            .setPopUpTo(dashboardRoute, true)
            .build()
    }
}