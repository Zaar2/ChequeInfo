package com.zaar.chequeinfo.model.repository

import com.zaar.chequeinfo.model.dataSource.local.room.entityIO.ChequeDbOutput
import com.zaar.chequeinfo.model.dataModel.cheque.ChequeModel

interface LocalDbRepository {

    suspend fun setChequesModel(chequesModel: List<ChequeModel>): Map<Int, Int>
//    suspend fun setCheque(cheque: ChequeModel): Long
    suspend fun getAllChequesModel(): List<ChequeModel>
    suspend fun getAllTbl(): List<String>
}