package com.modsen.tasksstepan.UI.Posts

sealed interface PostsEvent {
    data class NavigateToPost(val postId: Int) : PostsEvent
}
