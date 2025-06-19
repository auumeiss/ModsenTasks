package com.modsen.tasksstepan.Domain.Posts.Repository

import com.modsen.tasksstepan.Domain.Posts.Module.PostsDomainModule
import com.modsen.tasksstepan.Utils.MyException
import com.modsen.tasksstepan.Utils.TResult

interface IPostsRepository {
    suspend fun getPosts(): TResult<List<PostsDomainModule>, MyException>
}