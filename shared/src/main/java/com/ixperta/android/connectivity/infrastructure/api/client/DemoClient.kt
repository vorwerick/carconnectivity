package com.ixperta.android.connectivity.infrastructure.api.client

import com.google.gson.GsonBuilder
import com.ixperta.android.connectivity.configuration.api.NetworkConfig
import com.ixperta.android.connectivity.infrastructure.api.DemoApiService
import com.ixperta.android.connectivity.infrastructure.api.client.authorization.DemoBasicAuthInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DemoClient(
    private val config: NetworkConfig,
    private val authInterceptor: DemoBasicAuthInterceptor
) {

    fun createService(): DemoApiService {
        // logging
        val loggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        // authorization
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(authInterceptor)
            .build()
        val gson = GsonBuilder().setLenient().create()

        // retrofit
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(config.getBaseUrl())
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(DemoApiService::class.java)
    }

}