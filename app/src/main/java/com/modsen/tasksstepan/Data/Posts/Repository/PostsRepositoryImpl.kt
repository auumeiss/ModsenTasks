package com.modsen.tasksstepan.Data.Posts.Repository

import com.modsen.tasksstepan.Data.Posts.API.PostsApi
import com.modsen.tasksstepan.Data.Posts.Model.PostsDataModel
import com.modsen.tasksstepan.Domain.Posts.Model.PostsDomainModel
import com.modsen.tasksstepan.Domain.Posts.Repository.IPostsRepository
import com.modsen.tasksstepan.Domain.Utils.MyException
import com.modsen.tasksstepan.Domain.Utils.TResult
import com.modsen.tasksstepan.Domain.Utils.toMyException

class PostsRepositoryImpl(private val api:PostsApi):IPostsRepository  {
    fun PostsDataModel.toDomain():PostsDomainModel{
        return PostsDomainModel(id=id,title=title,body=body)
    }
    override suspend fun getPosts(): TResult<List<PostsDomainModel>, MyException> {
        return try {
            val result = api.getPosts()
            val mapped = result.map { it.toDomain() }
            TResult.Success(mapped)
        } catch (e:Throwable){
            TResult.Error(e.toMyException())
        }
    }
}