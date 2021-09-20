package eu.krzysztofdrobek.reddit.feature.postdetails

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import eu.krzysztofdrobek.reddit.navigation.NavigationManager
import eu.krzysztofdrobek.reddit.navigation.PostDetailsDirections
import org.koin.androidx.compose.get

@Composable
fun PostDetailsScreen(navigationManager: NavigationManager = get()) {
    Text(text = "PostDetailsScreen", Modifier.clickable {
        navigationManager.navigate(PostDetailsDirections.share)
    })
}