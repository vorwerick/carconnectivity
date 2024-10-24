package com.ixperta.android.connectivity.infrastructure.user

import com.ixperta.android.connectivity.domain.user.entity.UserEntity
import com.ixperta.android.connectivity.domain.user.repository.UserRepository

class FakeUserRepository : UserRepository {
    override fun getCurrentUser(): UserEntity {
        return UserEntity("miroslav.vinter@skoda-auto.cz")
    }
}