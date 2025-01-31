package com.zaar.chequeinfo.views.fragment.information

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zaar.chequeinfo.model.dataModel.cheque.ChequeModel
import com.zaar.chequeinfo.model.repository.LocalDbRepositoryImpl
import com.zaar.chequeinfo.viewModels.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InformationViewModel(
) : BaseViewModel() {

    private var chequeList: List<ChequeModel> = emptyList()

    fun getSummarizedInfo() {
        viewModelScope.launch(Dispatchers.IO) {
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