package com.zaar.chequeinfo.model.dataSource.local.room.dao

import androidx.room.Dao
import com.zaar.chequeinfo.model.dataSource.local.room.entityDB.ItemDb

@Dao
interface ItemDao : BaseDao<ItemDb> {
}