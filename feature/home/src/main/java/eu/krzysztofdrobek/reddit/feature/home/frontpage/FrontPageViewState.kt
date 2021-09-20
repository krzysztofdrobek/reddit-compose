package eu.krzysztofdrobek.reddit.feature.home.frontpage

import eu.krzysztofdrobek.reddit.feature.home.frontpage.list.FrontPageListItem

data class FrontPageViewState(
    val isLoading: Boolean,
    val items: List<FrontPageListItem>
) {
    companion object {
        val INITIAL = FrontPageViewState(
            isLoading = true,
            items = emptyList()
        )
    }
}