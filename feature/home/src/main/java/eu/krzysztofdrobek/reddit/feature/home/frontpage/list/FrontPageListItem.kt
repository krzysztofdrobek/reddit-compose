package eu.krzysztofdrobek.reddit.feature.home.frontpage.list

sealed class FrontPageListItem {
    object LoadingItem : FrontPageListItem()

    data class Header(
        val text: String
    ) : FrontPageListItem()

    data class Post(
        val title: String,
        val imageUrl: String? = null,
        val commentsCount: Int,
        val clickListener: (String) -> Unit
    ) : FrontPageListItem()
}