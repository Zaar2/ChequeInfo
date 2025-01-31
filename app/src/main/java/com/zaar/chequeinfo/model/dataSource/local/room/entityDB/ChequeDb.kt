package com.zaar.chequeinfo.model.dataSource.local.room.entityDB

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zaar.chequeinfo.model.dataModel.cheque.UserData
import kotlinx.datetime.format.DateTimeComponents

@Entity(
    tableName = "cheque",
)
data class ChequeDb(
    @PrimaryKey(autoGenerate = false)
    val _id: String = "",
    @ColumnInfo(
        typeAffinity = ColumnInfo.TEXT,
        name = "created_at"
    )
    val createdAt: DateTimeComponents? = null,

    @Embedded
    val user_data: UserData
)