package eu.krzysztofdrobek.reddit.feature.post

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import eu.krzysztofdrobek.reddit.navigation.NavigationManager
import eu.krzysztofdrobek.reddit.navigation.direction.PostDirections
import org.koin.androidx.compose.get

@Composable
fun PostDetailsScreen(postId: String, navigationManager: NavigationManager = get()) {
    Text(text = "PostDetailsScreen $postId", Modifier.clickable {
        navigationManager.navigate(PostDirections.share(postId))
    })
}