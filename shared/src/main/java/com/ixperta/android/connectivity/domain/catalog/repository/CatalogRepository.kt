package com.ixperta.android.connectivity.domain.catalog.repository

import arrow.core.Either
import com.ixperta.android.connectivity.domain.catalog.enity.PlanEntity

interface CatalogRepository {

    suspend fun getAllPlans(): Either<Unit, List<PlanEntity>>

}