package com.zaar.chequeinfo.model.dataModel.cheque

import kotlinx.serialization.Serializable

@Serializable
data class Properties(
    val propertyName: String = "",
    val propertyValue: String = "",
)
