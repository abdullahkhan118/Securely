package com.horux.convoauthenticator.mvc.repositories

import com.horux.convoauthenticator.mvc.models.TempPasswordDao
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
abstract class TempPasswordRepository(
    private val template: R2dbcEntityTemplate
): CoroutineCrudRepository<TempPasswordDao,String> {

    suspend fun insert(entity: TempPasswordDao): TempPasswordDao = template.insert(entity).awaitSingle()
}