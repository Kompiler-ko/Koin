package com.pss.koin.example

import com.pss.koin.model.GiphyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyApi {

    @GET("/v1/gifs/trending")
    suspend fun getGiphyGifs(
        @Query("api_key") key: String = "1cJEVIVrfiLIrRXPk0BcVNJiEmJj1aVV",
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int,
        @Query("lang") lang: String = "ko",
        @Query("bundle") bundle: String = "clips_grid_picker"
    ): Response<GiphyResponse>
}