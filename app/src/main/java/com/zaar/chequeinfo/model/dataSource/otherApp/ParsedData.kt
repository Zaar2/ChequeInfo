package com.zaar.chequeinfo.model.dataSource.otherApp

import com.zaar.chequeinfo.model.dataModel.cheque.ChequeModel
import com.zaar.chequeinfo.utilities.functions.FuncChequesList
import kotlinx.serialization.json.Json
import javax.inject.Inject

class ParsedData @Inject constructor(
    private val uploadData: UploadData
) {
    var chequeModels: List<ChequeModel> = emptyList()
        get() =
            FuncChequesList.decodeStrToPojo(
                uploadData.selData,
                true
            )
}