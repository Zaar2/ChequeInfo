package com.zaar.chequeinfo.model.dataSource.local.room.entityDB

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.zaar.chequeinfo.model.dataModel.cheque.Item

@Entity(
    tableName = "item",
    foreignKeys = [
        ForeignKey(
            entity = ChequeDb::class,
            parentColumns = arrayOf("_id"),
            childColumns = arrayOf("cheque_id"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
            deferred = true
        )
    ],
    indices = [Index(
        value = [
            "fiscalDocumentNumber",
            "fiscalDriveNumber",
            "kktRegId",
            "dateTime",
            "name",
            "rawProductCode",
            "quantity"
        ],
        unique = true
    )]
)
data class ItemDb(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    val dateTime: Long,
    val fiscalDocumentNumber: Long,
    val fiscalDriveNumber: String,
    val kktRegId: String,
    @Embedded
    var item: Item,
    @ColumnInfo(name = "cheque_id")
    val chequeId: String
)