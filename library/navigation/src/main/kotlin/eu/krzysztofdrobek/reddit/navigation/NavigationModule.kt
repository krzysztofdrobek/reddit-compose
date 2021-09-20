package eu.krzysztofdrobek.reddit.navigation

import org.koin.dsl.module

val navigationModule = module {
    single { NavigationManager() }
}