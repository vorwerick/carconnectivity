package com.ixperta.android.connectivity.infrastructure.api.client.authorization

import com.ixperta.android.connectivity.configuration.api.NetworkConfig
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

class DemoBasicAuthInterceptor(config: NetworkConfig) : Interceptor {
    private var credentials: String = Credentials.basic(config.getUserName(), config.getPassword())

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder().header("Authorization", credentials).build()
        return chain.proceed(request)
    }

}