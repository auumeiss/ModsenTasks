package com.modsen.tasksstepan.UI.Posts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.modsen.tasksstepan.Domain.Posts.Module.PostsDomainModule
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostsScreen(
    viewModel: PostsViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val intent by remember { mutableStateOf(viewModel::sendIntent) }

    val selectedPost = remember { mutableStateOf<PostsDomainModule?>(null) }
    val sheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            state.isLoading -> CustomLoader()
            state.error != null -> Text("Error: ${state.error}")
            else -> LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(state.posts) { post ->
                    PostCard(
                        title = post.title,
                        body = post.body,
                        onClick = {
                            selectedPost.value = post
                            coroutineScope.launch { sheetState.show() }
                        }
                    )
                }
            }
        }

        selectedPost.value?.let { post ->
            ModalBottomSheet(
                onDismissRequest = {
                    coroutineScope.launch {
                        sheetState.hide()
                        selectedPost.value = null
                    }
                },
                sheetState = sheetState
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = post.title,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = post.body,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}