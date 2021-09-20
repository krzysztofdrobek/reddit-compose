package eu.krzysztofdrobek.reddit.feature.home.frontpage

import androidx.lifecycle.ViewModel
import eu.krzysztofdrobek.reddit.feature.home.frontpage.list.FrontPageListItem
import eu.krzysztofdrobek.reddit.navigation.FeatureDirections
import eu.krzysztofdrobek.reddit.navigation.NavigationManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FrontPageViewModel(val navigationManager: NavigationManager) : ViewModel() {

    private val state = MutableStateFlow(FrontPageViewState.INITIAL)
    val viewState: StateFlow<FrontPageViewState> = state

    fun init() {
        state.value = state.value.copy(
            isLoading = false,
            items = listOf(
                FrontPageListItem.Post(
                    title = "Lorem ipsum",
                    commentsCount = 1,
                    clickListener = { navigationManager.navigate(FeatureDirections.postDetails) }
                ),
                FrontPageListItem.Post(
                    title = "Lorem ipsum 1",
                    commentsCount = 2,
                    clickListener = { navigationManager.navigate(FeatureDirections.postDetails) }
                ),
                FrontPageListItem.Post(
                    title = "Lorem ipsum 2",
                    commentsCount = 3,
                    clickListener = { navigationManager.navigate(FeatureDirections.postDetails) }
                ),
                FrontPageListItem.Post(
                    title = "Lorem ipsum 3",
                    commentsCount = 4,
                    clickListener = { navigationManager.navigate(FeatureDirections.postDetails) }
                ),
                FrontPageListItem.LoadingItem
            )
        )
    }

}