package com.zaar.chequeinfo.views.activity.uploadCheques

import androidx.lifecycle.viewModelScope
import com.zaar.chequeinfo.R
import com.zaar.chequeinfo.model.dataSource.otherApp.ParsedData
import com.zaar.chequeinfo.model.repository.LocalDbRepositoryImpl
import com.zaar.chequeinfo.viewModels.BaseViewModelSummarizedInf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UploadChequesViewModel(
    private val parsedData: ParsedData,
) : BaseViewModelSummarizedInf() {

    private val chequesList = parsedData.chequeModels

    fun getSummarizedInfo() = viewModelScope.launch(Dispatchers.IO) {
        currentProgress.set(0)
//        mldSetProgress.postValue(0)
        mldIsProgress.postValue(true)
        getSummarizedInformation(
            parsedData.chequeModels
        )
    }

    fun saveCheques() {
        viewModelScope.launch(Dispatchers.IO) {
            currentProgress.set(0)
//            mldSetProgress.postValue(0)
            mldIsProgress.postValue(true)
            LocalDbRepositoryImpl().apply {
                val map = setChequesModel(chequesModel = chequesList)
                val chequeRejected = chequesList.size -
                        map.getOrDefault(R.string.lblChequesUploaded, 0)
                map[R.string.lblChequesRejected] = chequeRejected
                mldMapResult.postValue(map)
            }
        }
    }
}