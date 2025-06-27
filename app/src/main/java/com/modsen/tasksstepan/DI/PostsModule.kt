package com.modsen.tasksstepan.DI

import com.modsen.tasksstepan.Data.Posts.API.PostsApi
import com.modsen.tasksstepan.Data.Posts.Repository.PostsRepositoryImpl
import com.modsen.tasksstepan.Data.Tasks.Repository.TasksRepositoryImpl
import com.modsen.tasksstepan.Domain.Posts.Repository.IPostsRepository
import com.modsen.tasksstepan.Domain.Tasks.Repository.ITasksRepository
import com.modsen.tasksstepan.Domain.Tasks.Usecase.GetTasksUseCase
import com.modsen.tasksstepan.UI.Posts.PostsViewModel
import com.modsen.tasksstepan.UI.Tasks.TasksListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val postsModule = module {

    single<PostsApi> {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostsApi::class.java)
    }

    single<IPostsRepository> { PostsRepositoryImpl(get()) }
    viewModel { PostsViewModel(get()) }
}