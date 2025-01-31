package com.zaar.chequeinfo.model.dataModel.cheque

import androidx.room.Embedded
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("items")
data class Item(
    val name: String = "",
    val nds: Int = 0,
    val paymentAgentByProductType: Int = -1,
    val ndsSum: Int = 0,
    val paymentType: Int = -1,
    val price: Int = 0,
    val productType: Int = 1,
    @Embedded
    val productCodeData: ProductCodeData = ProductCodeData(),
    val productCodeDataError: String = "",
    val providerInn: String = "",
    val quantity: Float = 0f,
    val sum: Int = 0
)
