package com.ixperta.android.connectivity.application

interface UseCaseAsyncWith<T, V> {
    suspend fun execute(value: V): T
}