package com.modsen.tasksstepan.Domain.Posts.Repository

import com.modsen.tasksstepan.Domain.Posts.Model.PostsDomainModel
import com.modsen.tasksstepan.Domain.Utils.MyException
import com.modsen.tasksstepan.Domain.Utils.TResult

interface IPostsRepository {
    suspend fun getPosts(): TResult<List<PostsDomainModel>, MyException>
}