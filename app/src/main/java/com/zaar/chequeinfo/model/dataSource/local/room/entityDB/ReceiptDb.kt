package com.zaar.chequeinfo.model.dataSource.local.room.entityDB

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.zaar.chequeinfo.model.dataModel.cheque.Receipt

@Entity(
    tableName = "receipt",
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
        value = ["fiscalDocumentNumber", "fiscalDriveNumber", "kktRegId", "dateTime"],
        unique = true
    )]
)
data class ReceiptDb(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "cheque_id")
    val chequeId: String,
    @Embedded
    var receipt: Receipt
)