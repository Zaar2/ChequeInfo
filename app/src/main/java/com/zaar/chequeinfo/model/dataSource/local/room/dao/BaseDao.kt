package com.zaar.chequeinfo.model.dataSource.local.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import androidx.room.Upsert

interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(obj: T): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(obj: List<T>): LongArray

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(obj: T): Int

    @Upsert
    suspend fun upsert(obj: T): Long

    @Upsert
    suspend fun upsert(obj: List<T>): LongArray

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(obj: List<T>): Int

    @Delete
    suspend fun delete(obj: T): Int

    @Delete
    suspend fun delete(obj: List<T>): Int
}