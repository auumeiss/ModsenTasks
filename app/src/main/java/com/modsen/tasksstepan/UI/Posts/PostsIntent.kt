package com.modsen.tasksstepan.UI.Posts

import com.google.android.gms.common.internal.Objects
import com.modsen.tasksstepan.UI.Posts.PostsIntent

sealed interface PostsIntent{
    object LoadPosts: PostsIntent
}