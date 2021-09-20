package eu.krzysztofdrobek.reddit.navigation

import kotlinx.coroutines.flow.MutableSharedFlow

class NavigationManager {
    var commands = MutableSharedFlow<NavigationCommand>(extraBufferCapacity = 1)

    fun navigate(directions: NavigationCommand) {
        commands.tryEmit(directions)
    }
}