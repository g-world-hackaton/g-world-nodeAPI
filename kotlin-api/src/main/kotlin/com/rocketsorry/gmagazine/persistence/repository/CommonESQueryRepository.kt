package com.rocketsorry.gmagazine.persistence.repository


import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery
import co.elastic.clients.elasticsearch._types.query_dsl.Query
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders

import com.rocketsorry.gmagazine.persistence.ESQueryBuilder
import com.rocketsorry.gmagazine.persistence.enum.IdField
import org.springframework.data.elasticsearch.core.SearchHits

interface CommonESQueryRepository<T : Any> : CommonElasticsearchRepository<T> {

    var esQueryBuilder: ESQueryBuilder

    fun idFieldType(): IdField

    fun findById(
        searchId: String,
    ): SearchHits<T> {
        val query = esQueryBuilder.term(idFieldType().fieldName, searchId)

        val boolQuery: BoolQuery = QueryBuilders.bool()
            .filter(query)
            .build()

        return search(Query(boolQuery), 1)
    }

    fun findByIds(
        searchIds: List<String>
    ): SearchHits<T> {
        val query = esQueryBuilder.terms(idFieldType().fieldName, searchIds)

        val boolQuery: BoolQuery = QueryBuilders.bool()
            .filter(query)
            .build()

        return search(Query(boolQuery))
    }

    fun findAllById(
        searchId: String,
        idField: IdField
    ): SearchHits<T> {
        val query = esQueryBuilder.term(idField.fieldName, searchId)

        val boolQuery: BoolQuery = QueryBuilders.bool()
            .filter(query)
            .build()

        return search(Query(boolQuery))
    }

    fun findAllWithSort(
        idField: IdField
    ): SearchHits<T> {
        val query = esQueryBuilder.deSort(idField.fieldName)
        return searchWithSort(query)
    }


}