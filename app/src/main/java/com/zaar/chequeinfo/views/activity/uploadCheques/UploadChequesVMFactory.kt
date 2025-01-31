package com.zaar.chequeinfo.views.activity.uploadCheques

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zaar.chequeinfo.model.dataSource.otherApp.ParsedData

class UploadChequesVMFactory(
    private val context: Context,
    private val parsedData: ParsedData
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UploadChequesViewModel(context, parsedData) as T
    }
}