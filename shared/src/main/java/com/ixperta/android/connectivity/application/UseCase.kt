package com.ixperta.android.connectivity.application

interface UseCase<T> {
    fun execute(): T
}