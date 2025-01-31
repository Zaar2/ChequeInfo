package com.zaar.chequeinfo.model.dataModel.cheque

import kotlinx.serialization.Serializable

@Serializable
data class Ticket(
    val document: Document = Document()
)
