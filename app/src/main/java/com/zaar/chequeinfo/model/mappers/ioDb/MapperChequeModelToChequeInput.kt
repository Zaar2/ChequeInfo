package com.zaar.chequeinfo.model.mappers.ioDb

import com.zaar.chequeinfo.model.dataSource.local.room.entityDB.ChequeDb
import com.zaar.chequeinfo.model.dataSource.local.room.entityDB.ItemDb
import com.zaar.chequeinfo.model.dataSource.local.room.entityDB.ReceiptDb
import com.zaar.chequeinfo.model.dataSource.local.room.entityIO.ChequeDbInput
import com.zaar.chequeinfo.model.dataModel.cheque.ChequeModel

class MapperChequeModelToChequeInput {
    suspend fun execute(chequesModel: List<ChequeModel>) =
        ChequeDbInput().apply {
            val cheques = mutableListOf<ChequeDb>()
            val receipts = mutableListOf<ReceiptDb>()
            val items = mutableListOf<ItemDb>()
            MapperChequeParsedToChequeOutput(chequesModel).execute()
                .forEach { chequeDbOutput ->
                    cheques.add(chequeDbOutput.chequeDb)
                    receipts.add(chequeDbOutput.receipt)
                    items.addAll(chequeDbOutput.items)
                }
            this.cheques = cheques.toList()
            this.receipts = receipts.toList()
            this.items = items.toList()
        }
}