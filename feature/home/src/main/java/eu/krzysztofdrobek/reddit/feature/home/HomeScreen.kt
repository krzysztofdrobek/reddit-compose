package eu.krzysztofdrobek.reddit.feature.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import eu.krzysztofdrobek.reddit.feature.home.frontpage.FrontPageScreen
import eu.krzysztofdrobek.reddit.navigation.HomeDirections
import eu.krzysztofdrobek.reddit.navigation.NavigationCommand
import eu.krzysztofdrobek.reddit.navigation.NavigationManager
import org.koin.androidx.compose.get

@Composable
fun HomeScreen(
    tab: HomeSection,
    navigationManager: NavigationManager = get()
) {
    val items = HomeSection.values()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        selected = screen == tab,
                        onClick = {
                            navigationManager.navigate(screen.navigationCommand)
                        }
                    )
                }
            }
        }
    ) {
        when (tab) {
            HomeSection.FrontPage -> FrontPageScreen()
            HomeSection.Notifications -> FrontPageScreen()
            HomeSection.Profile -> ProfileScreen()
            HomeSection.Search -> FrontPageScreen()
        }
    }
}

enum class HomeSection(
    val icon: ImageVector,
    val navigationCommand: NavigationCommand
) {
    FrontPage(Icons.Filled.Home, HomeDirections.frontPage),
    Search(Icons.Filled.Search, HomeDirections.search),
    Notifications(Icons.Filled.Notifications, HomeDirections.notifications),
    Profile(Icons.Filled.Person, HomeDirections.profile)
}
