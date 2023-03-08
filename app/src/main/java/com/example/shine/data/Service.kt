package com.example.shine.data

import com.example.shine.songs.RecommendationResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Streaming
import retrofit2.http.Url

interface ShazamApi {

    @GET("/songs/list-recommendations?key=484129036&locale=en-US")
    suspend fun getRecommendations(
        @Header("X-RapidAPI-Key") apiKey: String,
        @Header("X-RapidAPI-Host") hostName: String
    ): Response<RecommendationResponse>

    @Streaming
    @GET
    suspend fun downloadFile(@Url fileUrl: String): Response<ResponseBody>
}