package eu.krzysztofdrobek.reddit.feature.home.frontpage

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.krzysztofdrobek.reddit.feature.home.frontpage.list.FrontPageListItem
import eu.krzysztofdrobek.reddit.navigation.NavigationManager
import eu.krzysztofdrobek.reddit.navigation.direction.PostDirections
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FrontPageViewModel(
    val navigationManager: NavigationManager
) : ViewModel() {

    private val state = MutableStateFlow(FrontPageViewState.INITIAL)
    val viewState: StateFlow<FrontPageViewState> = state

    init {
        Log.d("FrontPageViewModel", "INIT $this")
    }

    fun init() = viewModelScope.launch {
        state.value = state.value.copy(
            items = listOf(FrontPageListItem.LoadingItem)
        )
        val listItems = loadItems().map { id ->
            FrontPageListItem.Post(
                title = "Post title $id",
                commentsCount = id,
                clickListener = {
                    navigationManager.navigate(PostDirections.details(it))
                }
            )
        }
        state.value = state.value.copy(
            items = listOf(FrontPageListItem.Header("Header text")) + listItems
        )
    }

    private suspend fun loadItems(): List<Int> {
        delay(1000)
        return (0..100).toList()
    }
}
