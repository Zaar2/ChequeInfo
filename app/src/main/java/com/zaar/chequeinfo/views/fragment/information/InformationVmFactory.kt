package com.zaar.chequeinfo.views.fragment.information

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class InformationVmFactory(
): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return InformationViewModel() as T
    }
}