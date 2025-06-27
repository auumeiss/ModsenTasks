package com.modsen.tasksstepan.UI.Posts

import com.modsen.tasksstepan.Domain.Posts.Model.PostsDomainModel
import com.modsen.tasksstepan.Domain.Utils.MyException

data class PostsState(
    val isLoading:Boolean = false,
    val posts:List<PostsDomainModel> = emptyList(),
    val error:MyException?=null
)