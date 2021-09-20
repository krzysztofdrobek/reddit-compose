package eu.krzysztofdrobek.reddit.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

private const val GRAPH_APP = "GRAPH_APP"

fun initNavigation(
    vararg modules: NavigationModule,
    graphName: String = GRAPH_APP
) {
    NavigationModulesHolder.modules[graphName] = modules.toList()
}

fun NavGraphBuilder.createNavigation(
    navController: NavHostController,
    graphName: String = GRAPH_APP
) {
    NavigationModulesHolder.modules[graphName]?.forEach { module ->
        module.run { create(navController) }
    }
}

fun interface NavigationModule {
    fun NavGraphBuilder.create(navController: NavHostController)
}

internal object NavigationModulesHolder {
    val modules = mutableMapOf<String, List<NavigationModule>>()
}