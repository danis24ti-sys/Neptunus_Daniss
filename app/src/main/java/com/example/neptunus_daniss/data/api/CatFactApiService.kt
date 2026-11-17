package com.example.neptunus_daniss.data.api

import com.example.neptunus_daniss.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}
