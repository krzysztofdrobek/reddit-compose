package eu.krzysztofdrobek.reddit.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.krzysztofdrobek.reddit.ui.theme.RedditTheme

@Composable
fun RedditButton(onClick: () -> Unit, text: String) {
    Button(onClick = onClick, contentPadding = PaddingValues(10.dp)) {
        Text(text = text)
    }
}

@Preview("Default colors")
@Composable
fun TutorialPreview() {
    TutorialPreviewTemplate()
}

@Preview("Dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TutorialPreviewDark() {
    TutorialPreviewTemplate()
}

@Composable
fun TutorialPreviewTemplate() {
    RedditTheme {
        Surface {
            RedditButton({}, "Testowy tekst")
        }
    }
}
