package eu.krzysztofdrobek.reddit

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import eu.krzysztofdrobek.reddit.home.HomeScreen
import eu.krzysztofdrobek.reddit.ui.theme.RedditTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RedditTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun FirstScreen() {
    Surface {
        Text(
            text = "FirstScreen"
        )
    }
}

@Composable
fun SecondScreen() {
    Surface {
        Text(
            text = "Second Screen"
        )
    }
}