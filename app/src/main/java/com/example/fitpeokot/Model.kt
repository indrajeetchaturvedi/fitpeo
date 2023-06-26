package com.example.fitpeokot


import com.google.gson.annotations.SerializedName

data class Model(@field:SerializedName("albumId") var albumId: Int,
                 @field:SerializedName("id") var id: Int,
                 @field:SerializedName("title") var title: String,
                 @field:SerializedName("url") var url: String,
                 @field:SerializedName("thumbnailUrl") var thumbnailUrl: String)