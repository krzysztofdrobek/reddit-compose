package eu.krzysztofdrobek.reddit.feature.home.di

import eu.krzysztofdrobek.reddit.feature.home.frontpage.FrontPageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel { FrontPageViewModel(navigationManager = get()) }
}