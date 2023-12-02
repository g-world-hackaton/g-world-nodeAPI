package com.rocketsorry.gmagazine.persistence.repository.impl

import com.rocketsorry.gmagazine.persistence.ESQueryBuilder
import com.rocketsorry.gmagazine.persistence.doc.MagazineDoc
import com.rocketsorry.gmagazine.persistence.enum.IdField
import com.rocketsorry.gmagazine.persistence.repository.CommonESQueryRepository
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.stereotype.Repository

@Repository
class MagazineRepository(
    override var operations: ElasticsearchOperations,
    override var esQueryBuilder: ESQueryBuilder

) : CommonESQueryRepository<MagazineDoc> {
    override fun indexName() = "magazines"

    override fun docClassType() = MagazineDoc::class.java

    override fun idFieldType() = IdField.MAGAZINE

}