package com.ferhat.whoconnectedng.api

import com.ferhat.whoconnectedng.model.Device
import com.ferhat.whoconnectedng.model.Token
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.http.GET

interface HomeApi {
    @GET("whoconnected")
    suspend fun getDevices(): List<Device>

    @GET("getmvtoken") //TODO: Get Mac Vendors token from home server
    suspend fun getMVToken(): Token
}

object HomeService {
    val baseUrl = "https://ferhatsanli.duckdns.org/"

    fun createService(): HomeApi {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HomeApi::class.java)
    }
}