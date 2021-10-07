package eu.krzysztofdrobek.reddit.feature.post.share

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import eu.krzysztofdrobek.reddit.navigation.NavigationManager
import eu.krzysztofdrobek.reddit.navigation.direction.HomeDirections
import eu.krzysztofdrobek.reddit.navigation.direction.PostDirections
import org.koin.androidx.compose.get

@Composable
fun PostDetailsShareScreen(postId: String, navigationManager: NavigationManager = get()) {
    Text(text = "PostDetailsShareScreen $postId", Modifier.clickable {
        navigationManager.navigate(HomeDirections.dashboard())
    })
}