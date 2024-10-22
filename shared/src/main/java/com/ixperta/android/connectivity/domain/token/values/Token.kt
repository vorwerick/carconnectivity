package com.ixperta.android.connectivity.domain.token.values

data class Token(val value: String) {
    init {
        if(value.isEmpty()){
            throw IllegalArgumentException("Token can not be empty")
        }
    }
}