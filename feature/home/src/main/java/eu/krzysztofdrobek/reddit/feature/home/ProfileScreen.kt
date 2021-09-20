package eu.krzysztofdrobek.reddit.feature.home

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import eu.krzysztofdrobek.reddit.navigation.FeatureDirections
import eu.krzysztofdrobek.reddit.navigation.NavigationManager
import org.koin.androidx.compose.get

@Composable
fun ProfileScreen(navigationManager: NavigationManager = get()) {
    Text("ProfileScreen", Modifier.clickable {
        navigationManager.navigate(FeatureDirections.postDetails)
    })
}