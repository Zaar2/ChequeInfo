package com.zaar.chequeinfo.model.dataSource.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.zaar.chequeinfo.model.dataSource.local.room.entityDB.ChequeDb
import com.zaar.chequeinfo.model.dataSource.local.room.entityIO.ChequeDbOutput

@Dao
interface ChequeDao : BaseDao<ChequeDb> {

    @Transaction
    @Query("select * from cheque")
    suspend fun getAllCheques(): List<ChequeDbOutput>

    @Query("select _id from cheque where rowId=:rowId")
    suspend fun getIdByRowId(rowId: Long): String
}