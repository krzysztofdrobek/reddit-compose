package eu.krzysztofdrobek.reddit.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class KoinInjection : Injection {
    override fun init(context: Context) {
        startKoin {
            androidLogger()
            androidContext(context)
            modules()
        }
    }
}