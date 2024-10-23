package com.ixperta.android.connectivity.application

interface UseCaseWith<T,V> {

    fun  execute(value:V):T
}