package com.zaar.chequeinfo.model.dataSource.local.room.entityIO

import androidx.room.Embedded
import androidx.room.Relation
import com.zaar.chequeinfo.model.dataSource.local.room.entityDB.ChequeDb
import com.zaar.chequeinfo.model.dataSource.local.room.entityDB.ItemDb
import com.zaar.chequeinfo.model.dataSource.local.room.entityDB.ReceiptDb

data class ChequeDbOutput(
    @Embedded
    var chequeDb: ChequeDb,
    @Relation(
        parentColumn = "_id",
        entity = ReceiptDb::class,
        entityColumn = "cheque_id"
    )
    var receipt: ReceiptDb,
    @Relation(
        parentColumn = "_id",
        entity = ItemDb::class,
        entityColumn = "cheque_id"
    )
    var items: List<ItemDb>
)
