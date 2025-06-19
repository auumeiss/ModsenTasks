package com.modsen.tasksstepan.UI.Posts

import com.modsen.tasksstepan.Domain.Posts.Module.PostsDomainModule
import com.modsen.tasksstepan.Utils.MyException

data class PostsState(
    val isLoading:Boolean = false,
    val posts:List<PostsDomainModule> = emptyList(),
    val error:MyException?=null
)