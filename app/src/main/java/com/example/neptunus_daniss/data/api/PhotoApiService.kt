package com.example.neptunus_daniss.data.api

import com.example.neptunus_daniss.data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}
