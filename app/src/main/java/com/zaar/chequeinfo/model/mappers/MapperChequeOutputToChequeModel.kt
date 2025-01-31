package com.zaar.chequeinfo.model.mappers

import com.zaar.chequeinfo.model.dataModel.cheque.ChequeModel
import com.zaar.chequeinfo.model.dataModel.cheque.Document
import com.zaar.chequeinfo.model.dataModel.cheque.Item
import com.zaar.chequeinfo.model.dataModel.cheque.Ticket
import com.zaar.chequeinfo.model.dataSource.local.room.entityDB.ItemDb
import com.zaar.chequeinfo.model.dataSource.local.room.entityIO.ChequeDbOutput

class MapperChequeOutputToChequeModel(
    private val chequesDbOutput: List<ChequeDbOutput>
) {
    suspend fun execute() =
        mutableListOf<ChequeModel>().apply {
            chequesDbOutput.forEach { chequeDbOutput ->
                add(
                    ChequeModel(
                        _id = chequeDbOutput.chequeDb._id,
                        createdAt = chequeDbOutput.chequeDb.createdAt,
                        user_data = chequeDbOutput.chequeDb.user_data,
                        ticket = Ticket(
                            Document(
                                chequeDbOutput.receipt.receipt
                            )
                        )
                    ).also {
                        it.ticket.document.receipt.items = itemsDbToItems(chequeDbOutput.items)
                    }
                )
            }
        }.toList()

    private fun itemsDbToItems(itemsDb: List<ItemDb>) =
        mutableListOf<Item>().apply {
            itemsDb.forEach {
                add(it.item)
            }
        }.toList()
}