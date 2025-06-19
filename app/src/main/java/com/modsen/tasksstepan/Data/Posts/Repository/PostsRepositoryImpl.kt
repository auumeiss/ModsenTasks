package com.modsen.tasksstepan.Data.Posts.Repository

import com.modsen.tasksstepan.Data.Posts.API.PostsApi
import com.modsen.tasksstepan.Data.Posts.Model.PostsDataModel
import com.modsen.tasksstepan.Domain.Posts.Module.PostsDomainModule
import com.modsen.tasksstepan.Domain.Posts.Repository.IPostsRepository
import com.modsen.tasksstepan.Utils.MyException
import com.modsen.tasksstepan.Utils.TResult
import com.modsen.tasksstepan.Utils.toMyException

class PostsRepositoryImpl(private val api:PostsApi):IPostsRepository  {
    fun PostsDataModel.toDomain():PostsDomainModule{
        return PostsDomainModule(id=id,title=title,body=body)
    }
    override suspend fun getPosts(): TResult<List<PostsDomainModule>, MyException> {
        return try {
            val result = api.getPosts()
            val mapped = result.map { it.toDomain() }
            TResult.Success(mapped)
        } catch (e:Throwable){
            TResult.Error(e.toMyException())
        }
    }
}