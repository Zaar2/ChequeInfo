package com.zaar.chequeinfo.model.dataModel.cheque

import kotlinx.serialization.Serializable

@Serializable
data class Document(
    val receipt: Receipt = Receipt()
)