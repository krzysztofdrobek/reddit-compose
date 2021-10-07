package eu.krzysztofdrobek.reddit

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import eu.krzysztofdrobek.reddit.navigation.NavigationManager
import eu.krzysztofdrobek.reddit.navigation.createNavigation
import eu.krzysztofdrobek.reddit.navigation.direction.HomeDirections
import eu.krzysztofdrobek.reddit.ui.theme.RedditTheme
import kotlinx.coroutines.flow.collect
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val navigation: NavigationManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RedditTheme {
                Surface {
                    val navController = rememberNavController()
                    LaunchedEffect(navController) {
                        navigation.commands.collect {
                            navController.navigate(it.destination, it.navOptions)
                        }
                    }

                    NavHost(
                        navController = navController,
                        startDestination = HomeDirections.dashboardRoute
                    ) {
                        createNavigation(navController)
                    }
                }
            }
        }
    }
}