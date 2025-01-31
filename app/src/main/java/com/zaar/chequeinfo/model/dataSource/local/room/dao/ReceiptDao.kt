package com.zaar.chequeinfo.model.dataSource.local.room.dao

import androidx.room.Dao
import com.zaar.chequeinfo.model.dataSource.local.room.entityDB.ReceiptDb

@Dao
interface ReceiptDao : BaseDao<ReceiptDb> {
}