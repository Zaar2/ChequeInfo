package com.zaar.chequeinfo.model.dataModel.cheque

import androidx.room.ColumnInfo
import kotlinx.serialization.Serializable

@Serializable
data class ProductCodeData(
//    @ColumnInfo(
//        typeAffinity = ColumnInfo.TEXT
//    )
    val gtin: Long = 0L,
    val rawProductCode: String = "",
    val productIdType: Int = -1,
    val sernum: String = "",
)
