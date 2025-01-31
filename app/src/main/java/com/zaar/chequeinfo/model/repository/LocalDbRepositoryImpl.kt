package com.zaar.chequeinfo.model.repository

import android.content.Context
import androidx.sqlite.db.SimpleSQLiteQuery
import com.zaar.chequeinfo.R
import com.zaar.chequeinfo.app.App
import com.zaar.chequeinfo.model.dataSource.local.room.database.DatabaseChequeInf
import com.zaar.chequeinfo.model.dataModel.cheque.ChequeModel
import com.zaar.chequeinfo.model.mappers.ioDb.MapperChequeModelToChequeInput
import com.zaar.chequeinfo.model.mappers.MapperChequeOutputToChequeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalDbRepositoryImpl(
    private val context: Context
) : LocalDbRepository {

    @Inject
    lateinit var db: DatabaseChequeInf

    init {
        App.getAppComponent()
            .injectLocalDbRepository(this)
    }

    override suspend fun setChequesModel(chequesModel: List<ChequeModel>): MutableMap<Int, Int> =
        MapperChequeModelToChequeInput().execute(chequesModel).run {
            mutableMapOf<Int, Int>().also { mapResult ->
                //obtaining of result of insert the cheques heading to database table
                val mapIdAndRowId = mutableMapOf<String, Long>()
                    .also {
                        cheques.forEach { cheque ->
                            it[cheque._id] = db.getChequeDao().insert(cheque)
                        }
                    }.filter {
                        it.value != -1L
                    }
                //check and delete elements from list of 'receipts' and 'items'
                receipts = receipts.filter { receipt ->
                    mapIdAndRowId.containsKey(receipt.chequeId)
                }
                items = items.filter { item ->
                    mapIdAndRowId.containsKey(item.chequeId)
                }
                //insert receipts and items to database tables
                mapResult[R.string.lblChequesUploaded] =
                    db.getReceiptDao().insert(receipts)
                        .filter { it != -1L }
                        .size
                mapResult[R.string.lblRecordsUploaded] =
                    db.getItemDao().insert(items)
                        .filter { it != -1L }
                        .size
            }
        } ?: mutableMapOf<Int, Int>()

    override suspend fun getAllChequesModel(): List<ChequeModel> =
        db.getChequeDao().getAllCheques()
            .let { listChequeDbOutput ->
                MapperChequeOutputToChequeModel(listChequeDbOutput).execute()
            }

    override suspend fun getAllTbl(): List<String> =
        withContext(Dispatchers.IO) {
            db.let { db ->
                val cursor = db.query(
                    SimpleSQLiteQuery(
                        "SELECT name FROM sqlite_master WHERE type='table' AND name NOT IN ('android_metadata', 'sqlite_sequence', 'room_master_table')"
                    )
                )
                arrayListOf<String>().let { tableNames ->
                    if (cursor.moveToFirst()) {
                        while (!cursor.isAfterLast) {
                            tableNames.add(cursor.getString(0))
                            cursor.moveToNext()
                        }
                    }
                    tableNames.toList()
                }
            }
        }
}