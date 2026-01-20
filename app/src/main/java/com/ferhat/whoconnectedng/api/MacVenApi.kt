package com.ferhat.whoconnectedng.api

import com.ferhat.whoconnectedng.model.MacData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface MacVenApi {
    @GET("v1/lookup/{mac}")
    suspend fun getMacData(
        @Path("mac") mac: String,
        @Header("Authorization") token: String): MacData
}

object MacVenService {
    val baseUrl = "https://api.macvendors.com/"
    fun createService(): MacVenApi {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MacVenApi::class.java)
    }
}