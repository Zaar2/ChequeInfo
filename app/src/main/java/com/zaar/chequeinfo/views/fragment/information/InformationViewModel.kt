package com.zaar.chequeinfo.views.fragment.information

import androidx.lifecycle.viewModelScope
import com.zaar.chequeinfo.model.dataModel.cheque.ChequeModel
import com.zaar.chequeinfo.model.repository.LocalDbRepositoryImpl
import com.zaar.chequeinfo.viewModels.BaseViewModelSummarizedInf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InformationViewModel : BaseViewModelSummarizedInf() {

    private var chequeList: List<ChequeModel> = emptyList()

    fun getSummarizedInfo() {
        viewModelScope.launch(Dispatchers.Main.immediate) {
//            mldIsProgress.postValue(true)
            currentProgress.set(0)
            chequeList = LocalDbRepositoryImpl().getAllChequesModel()
            getSummarizedInformation(chequeList)
        }
    }

    fun clearDatabase() {
        viewModelScope.launch(Dispatchers.IO) {
            LocalDbRepositoryImpl().clearDB()
        }
    }
}