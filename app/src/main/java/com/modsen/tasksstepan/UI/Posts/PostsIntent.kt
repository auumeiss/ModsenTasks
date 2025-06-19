package com.modsen.tasksstepan.UI.Posts

import com.google.android.gms.common.internal.Objects

sealed interface PostsIntent{
    object LoadPosts:PostsIntent
}