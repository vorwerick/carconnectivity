package com.ixperta.android.connectivity.infrastructure.api

import com.ixperta.android.connectivity.infrastructure.api.model.CatalogItem
import com.ixperta.android.connectivity.infrastructure.api.model.VehicleSupport
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface DemoApiService {

    @GET("catalog")
    suspend fun getCatalog(): List<CatalogItem>


    @GET("user/{email}")
    suspend fun getUserSupport(@Path("email") vin: String): List<String>

    @GET("{vin}")
    suspend fun getVehicleSupport(@Path("vin") vin: String): VehicleSupport

    @PUT("{vin}")
    suspend fun putVehicleSupport(@Path("vin") vin: String, @Body info: VehicleSupport)
}