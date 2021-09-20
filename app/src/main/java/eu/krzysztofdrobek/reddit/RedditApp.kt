package eu.krzysztofdrobek.reddit

import android.app.Application
import eu.krzysztofdrobek.reddit.feature.home.di.homeModule
import eu.krzysztofdrobek.reddit.feature.home.homeNavigationModule
import eu.krzysztofdrobek.reddit.feature.postdetails.postDetailsNavigationModule
import eu.krzysztofdrobek.reddit.navigation.initNavigation
import eu.krzysztofdrobek.reddit.navigation.navigationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext

class RedditApp : Application() {

    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidLogger()
            androidContext(this@RedditApp)
            modules(
                navigationModule,
                homeModule
            )
        }

        initNavigation(
            homeNavigationModule,
            postDetailsNavigationModule
        )
    }
}