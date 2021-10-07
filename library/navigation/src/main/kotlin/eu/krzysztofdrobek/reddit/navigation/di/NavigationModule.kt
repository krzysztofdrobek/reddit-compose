package eu.krzysztofdrobek.reddit.navigation.di

import eu.krzysztofdrobek.reddit.navigation.NavigationManager
import org.koin.dsl.module

val navigationModule = module {
    single { NavigationManager() }
}