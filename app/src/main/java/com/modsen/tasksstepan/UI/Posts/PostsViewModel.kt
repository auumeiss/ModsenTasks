package com.modsen.tasksstepan.UI.Posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.modsen.tasksstepan.Domain.Posts.Repository.IPostsRepository
import com.modsen.tasksstepan.UI.Common.SingleFlowEvent
import com.modsen.tasksstepan.Utils.TResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PostsViewModel(private val repository: IPostsRepository):ViewModel() {
    private val _state = MutableStateFlow(PostsState())
    val state: StateFlow<PostsState> = _state

    private val _event = SingleFlowEvent<PostsEvent>(viewModelScope)
    val event = _event.flow

    init {
        sendIntent(PostsIntent.LoadPosts)
    }

    fun sendIntent(intent: PostsIntent) {
        when (intent) {
            is PostsIntent.LoadPosts -> loadPosts()
        }
    }

    private fun loadPosts() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            when (val result = repository.getPosts()) {
                is TResult.Success -> _state.update {
                    it.copy(
                        posts = result.data,
                        isLoading = false
                    )
                }

                is TResult.Error -> _state.update {
                    it.copy(
                        error = result.error,
                        isLoading = false
                    )
                }
            }
        }
    }
}