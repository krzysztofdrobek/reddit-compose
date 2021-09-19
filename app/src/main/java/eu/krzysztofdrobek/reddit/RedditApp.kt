package eu.krzysztofdrobek.reddit

import android.app.Application
import eu.krzysztofdrobek.reddit.di.Injection
import eu.krzysztofdrobek.reddit.di.KoinInjection

class RedditApp : Application() {

    private val injection: Injection = KoinInjection()

    override fun onCreate() {
        super.onCreate()
        injection.init(this)
    }
}