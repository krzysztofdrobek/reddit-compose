package eu.krzysztofdrobek.reddit.feature.home.frontpage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.krzysztofdrobek.reddit.feature.home.frontpage.list.FrontPageListItem
import org.koin.androidx.compose.getViewModel

@Composable
fun FrontPageScreen(
    viewModel: FrontPageViewModel = getViewModel()
) = Box(Modifier.fillMaxSize()) {
    val state = viewModel.viewState.collectAsState()
    if (state.value == FrontPageViewState.INITIAL) {
        viewModel.init()
    }

    LazyColumn {
        items(state.value.items) { item ->
            when (item) {
                is FrontPageListItem.LoadingItem -> LoadingItem()
                is FrontPageListItem.Header -> Text(item.text)
                is FrontPageListItem.Post -> PostItem(item)
            }
        }
    }
}

@Composable
fun LoadingItem() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun PostItem(item: FrontPageListItem.Post) {
    Card(
        shape = MaterialTheme.shapes.large,
        elevation = 2.dp,
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .fillMaxWidth()
    ) {
        Column(
            Modifier
                .clickable { item.clickListener.invoke(item.title) }
                .background(MaterialTheme.colors.surface)
                .clip(MaterialTheme.shapes.large)
                .padding(16.dp)
        ) {
            Text(text = item.title)
            Text(text = item.commentsCount.toString())
        }
    }
}

@Preview
@Composable
fun ComposablePreview() {
    PostItem(
        FrontPageListItem.Post(
            title = "Lorem Ipsum",
            commentsCount = 11,
            clickListener = {}
        )
    )
}