package com.ixperta.android.connectivity.application

interface UseCaseAsync<T> {
    suspend fun execute(): T
}