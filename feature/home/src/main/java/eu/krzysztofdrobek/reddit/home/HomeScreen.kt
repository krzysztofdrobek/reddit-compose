package eu.krzysztofdrobek.reddit.home

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen() {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, ini) {

    }
    Text(
        text = "HomeScreen",
        Modifier.clickable {  }
    )
}