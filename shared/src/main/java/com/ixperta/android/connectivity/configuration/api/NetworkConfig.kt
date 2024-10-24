package com.ixperta.android.connectivity.configuration.api

class NetworkConfig {

    fun getBaseUrl(): String {
        return "https://demo.ixperta.cz/api/v1/"
    }

    fun getUserName(): String {
        return "skoda"
    }

    fun getPassword(): String {
        return "C0nnect!Srv"
    }
}