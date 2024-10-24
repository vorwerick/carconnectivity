package com.ixperta.android.connectivity.application.car

import com.ixperta.android.connectivity.application.UseCaseAsync
import com.ixperta.android.connectivity.domain.catalog.enity.PlanEntity
import com.ixperta.android.connectivity.infrastructure.catalog.DemoCatalogRepository


class GetProductPlans(private val catalogRepository: DemoCatalogRepository) :
    UseCaseAsync<List<PlanEntity>> {
    override suspend fun execute(): List<PlanEntity> {
        val result = catalogRepository.getAllPlans()

        return result.fold({ listOf() }, { it })
    }
}