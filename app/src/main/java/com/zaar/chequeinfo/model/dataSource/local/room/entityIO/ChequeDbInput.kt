package com.zaar.chequeinfo.model.dataSource.local.room.entityIO

import com.zaar.chequeinfo.model.dataSource.local.room.entityDB.ChequeDb
import com.zaar.chequeinfo.model.dataSource.local.room.entityDB.ItemDb
import com.zaar.chequeinfo.model.dataSource.local.room.entityDB.ReceiptDb

data class ChequeDbInput(
    var cheques: List<ChequeDb> = emptyList(),
    var receipts: List<ReceiptDb> = emptyList(),
    var items: List<ItemDb> = emptyList(),
)
