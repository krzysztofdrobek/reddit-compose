package eu.krzysztofdrobek.reddit.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import androidx.navigation.NavOptions

interface NavigationCommand {
    val destination: String
    val navOptions: NavOptions?
        get() = null
    val arguments: List<NamedNavArgument>
        get() = emptyList()
    val deepLinks: List<NavDeepLink>
        get() = emptyList()
}