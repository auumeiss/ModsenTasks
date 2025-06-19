package com.modsen.tasksstepan.UI.Posts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun PostsScreen(
    viewModel: PostsViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val intent by remember { mutableStateOf(viewModel::sendIntent) }

    when {
        state.isLoading -> CustomLoader()
        state.error != null -> Text("Error: ${state.error}")
        else -> LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.posts) { post ->
                PostCard(title = post.title, body = post.body)
            }
        }
    }
}