package eu.krzysztofdrobek.reddit.feature.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import eu.krzysztofdrobek.reddit.feature.home.frontpage.FrontPageScreen
import eu.krzysztofdrobek.reddit.navigation.NavigationCommand

@Composable
fun HomeScreen(
    navigationCommand: NavigationCommand? = null
) {
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()
    val items = HomeSection.values()

    LaunchedEffect(navController) {
        navigationCommand?.let {
            navController.navigate(it.destination, it.navOptions)
        }
    }

    Scaffold(
        bottomBar = {
            BottomNavigation {
                items.forEach { screen ->
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    BottomNavigationItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.navigationCommand.destination } == true,
                        onClick = {
                            navController.navigate(
                                screen.navigationCommand.destination,
                                screen.navigationCommand.navOptions
                            )
                        }
                    )
                }
            }
        },
        scaffoldState = scaffoldState
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = DashboardDirections.Route.frontPage,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(DashboardDirections.Route.frontPage) {
                FrontPageScreen()
            }
            composable(DashboardDirections.Route.profile) {
                ProfileScreen()
            }
            composable(DashboardDirections.Route.search) {
                FrontPageScreen()
            }
            composable(DashboardDirections.Route.notifications) {
                ProfileScreen()
            }
        }
    }
}

enum class HomeSection(
    val icon: ImageVector,
    val navigationCommand: NavigationCommand
) {
    FrontPage(Icons.Filled.Home, DashboardDirections.frontPage()),
    Search(Icons.Filled.Search, DashboardDirections.search()),
    Notifications(Icons.Filled.Notifications, DashboardDirections.notifications()),
    Profile(Icons.Filled.Person, DashboardDirections.profile())
}
