package com.ixperta.android.connectivity.infrastructure.catalog

import arrow.core.Either
import coil.network.HttpException
import com.ixperta.android.connectivity.domain.catalog.enity.PlanEntity
import com.ixperta.android.connectivity.domain.catalog.repository.CatalogRepository
import com.ixperta.android.connectivity.infrastructure.api.DemoApiService

class DemoCatalogRepository(private val api: DemoApiService) : CatalogRepository {
    override suspend fun getAllPlans(): Either<Unit, List<PlanEntity>> {

        try {

            val result = api.getCatalog()

            val catalog = result.map {
                PlanEntity(
                    it.name,
                    it.displayName,
                    it.subtitle,
                    it.priceMonthly,
                    it.priceAnnually,
                    it.priceUnit
                )
            }
            return Either.Right(catalog)

        } catch (e: HttpException) {
            return Either.Left(Unit)
        }


    }
}