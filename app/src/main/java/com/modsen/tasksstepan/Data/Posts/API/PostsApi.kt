package com.modsen.tasksstepan.Data.Posts.API

import com.modsen.tasksstepan.Data.Posts.Model.PostsDataModel
import retrofit2.http.GET

interface PostsApi {
    @GET("/posts")
    suspend fun getPosts():List<PostsDataModel>
}