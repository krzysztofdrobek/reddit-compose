package eu.krzysztofdrobek.reddit.feature.home.profile

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import eu.krzysztofdrobek.reddit.navigation.NavigationManager
import eu.krzysztofdrobek.reddit.navigation.direction.PostDirections
import org.koin.androidx.compose.get

@Composable
fun ProfileScreen(navigationManager: NavigationManager = get()) {
    Text("ProfileScreen", Modifier.clickable {
        navigationManager.navigate(PostDirections.details("1"))
    })
}