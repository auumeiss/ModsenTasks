package com.modsen.tasksstepan.Data.Posts.Model

import androidx.resourceinspection.annotation.Attribute.IntMap

data class PostsDataModel (
    val userId: Int,
    val id:Int,
    val title:String,
    val body:String
)