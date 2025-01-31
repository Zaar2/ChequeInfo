package com.zaar.chequeinfo.model.mappers.ioDb

import com.zaar.chequeinfo.model.dataSource.local.room.entityDB.ChequeDb
import com.zaar.chequeinfo.model.dataSource.local.room.entityDB.ItemDb
import com.zaar.chequeinfo.model.dataSource.local.room.entityDB.ReceiptDb
import com.zaar.chequeinfo.model.dataSource.local.room.entityIO.ChequeDbOutput
import com.zaar.chequeinfo.model.dataModel.cheque.ChequeModel
import com.zaar.chequeinfo.model.dataSource.local.room.converter.ConverterDate

class MapperChequeParsedToChequeOutput(
    private val chequesModel: List<ChequeModel>
) {
    suspend fun execute(): List<ChequeDbOutput> =
        mutableListOf<ChequeDbOutput>().apply {
            chequesModel.forEach { chequeParsed ->
                add(
                    ChequeDbOutput(
                        chequeDb = ChequeDb(
                            _id = chequeParsed._id,
                            user_data = chequeParsed.user_data,
                            createdAt = chequeParsed.createdAt,
                        ),
                        receipt = ReceiptDb(
                            chequeId = chequeParsed._id,
                            receipt = chequeParsed.ticket.document.receipt
                        ),
                        items = mutableListOf<ItemDb>().also { itemsOutput ->
                            chequeParsed.ticket.document.receipt.items.forEach { itemParsed ->
                                itemsOutput.add(
                                    ItemDb(
                                        chequeId = chequeParsed._id,
                                        item = itemParsed,
                                        fiscalDocumentNumber = chequeParsed.ticket.document.receipt.fiscalDocumentNumber,
                                        fiscalDriveNumber = chequeParsed.ticket.document.receipt.fiscalDriveNumber,
                                        kktRegId = chequeParsed.ticket.document.receipt.kktRegId,
                                        dateTime = chequeParsed.ticket.document.receipt.dateTime?.let {
                                            ConverterDate().dateTimeToTimestamp(
                                                it
                                            )
                                        } ?: -1L
                                    )
                                )
                            }
                        }.toList()
                    )
                )
            }
        }.toList()
}