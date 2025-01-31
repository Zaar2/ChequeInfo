package com.zaar.chequeinfo.model.dataSource.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface DatabaseDao {

    @Query("delete from sqlite_sequence")
    suspend fun clearSqliteSequence()
}