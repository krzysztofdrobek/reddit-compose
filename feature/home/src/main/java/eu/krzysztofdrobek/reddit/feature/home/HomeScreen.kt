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
import eu.krzysztofdrobek.reddit.feature.home.profile.ProfileScreen
import eu.krzysztofdrobek.reddit.navigation.NavigationCommand

@Composable
fun HomeScreen() {
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val hierarchy = navBackStackEntry?.destination?.hierarchy

    Scaffold(
        bottomBar = {
            HomeBottomNavigation(
                isSelected = { route -> hierarchy?.any { it.route == route } == true },
                onClick = { navController.navigate(it.destination, it.navOptions) }
            )
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

@Composable
fun HomeBottomNavigation(
    isSelected: (String) -> Boolean,
    onClick: (NavigationCommand) -> Unit
) {
    val items = HomeSection.values()
    BottomNavigation {
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(screen.icon, contentDescription = null) },
                selected = isSelected.invoke(screen.navigationCommand.destination),
                onClick = { onClick.invoke(screen.navigationCommand) }
            )
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
