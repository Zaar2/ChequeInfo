package com.zaar.chequeinfo.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zaar.chequeinfo.data.Primitives
import com.zaar.chequeinfo.model.dataModel.cheque.ChequeModel
import com.zaar.chequeinfo.utilities.functions.FuncChequesList
import com.zaar.chequeinfo.utilities.serializers.FormatterLocalDateTime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format.DateTimeFormat
import java.text.DecimalFormat

open class BaseViewModel(
//    protected val chequesList: List<ChequeModel>
) : ViewModel() {

    protected var mldFirstDay = MutableLiveData<String>()
    fun ldFirstDay(): LiveData<String> = mldFirstDay

    protected var mldLastDay = MutableLiveData<String>()
    fun ldLastDay(): LiveData<String> = mldLastDay

    protected var mldCountGoods = MutableLiveData<String>()
    fun ldCountGoods(): LiveData<String> = mldCountGoods

    protected var mldCountCheques = MutableLiveData<String>()
    fun ldCountCheques(): LiveData<String> = mldCountCheques

    protected var mldCountRecords = MutableLiveData<String>()
    fun ldCountRecords(): LiveData<String> = mldCountRecords

    protected var mldCountSellers = MutableLiveData<String>()
    fun ldCountSellers(): LiveData<String> = mldCountSellers

    protected var mldTotalCost = MutableLiveData<String>()
    fun ldTotalCost(): LiveData<String> = mldTotalCost

    protected var mldAvrCost = MutableLiveData<String>()
    fun ldAvrCost(): LiveData<String> = mldAvrCost

    protected var mldMapResult = MutableLiveData<Map<Int, Int>>()
    fun ldMapResult(): LiveData<Map<Int, Int>> = mldMapResult

    protected var formatter: DateTimeFormat<LocalDateTime> = FormatterLocalDateTime.formatterDate

    protected val floatFormat = DecimalFormat("#,###,##0.00")
    protected val integerFormat = DecimalFormat("#,###,##0")

    protected fun getSummarizedInformation(chequesList: List<ChequeModel>) =
        viewModelScope.launch(Dispatchers.IO) {
            val totalCost: Primitives<Float> = Primitives(0f)
            launch {
                mldFirstDay.postValue(
                    FuncChequesList.getFirstDay(
                        chequesList,
                        formatter
                    )
                )
            }
            launch {
                mldCountRecords.postValue(
                    integerFormat.format(
                        FuncChequesList.getCountRecords(chequesList)
                    )
                )
            }
            launch {
                mldLastDay.postValue(
                    FuncChequesList.getLastDay(
                        chequesList,
                        formatter
                    )
                )
            }
            launch {
                mldCountCheques.postValue(
                    integerFormat.format(
                        FuncChequesList.getCountCheques(chequesList)
                    )
                )
            }
            launch {
                mldCountGoods.postValue(
                    integerFormat.format(
                        FuncChequesList.getCountGoods(chequesList)
                    )
                )
            }
            launch {
                mldCountSellers.postValue(
                    integerFormat.format(
                        FuncChequesList.getCountSellers(chequesList)
                    )
                )
            }

            val jobTotalCost = launch {
                mldTotalCost.postValue(
                    floatFormat.format(
                        FuncChequesList.getTotalCost(
                            totalCost,
                            chequesList
                        )
                    )
                )
            }

            jobTotalCost.join()
            launch {
                mldAvrCost.postValue(
                    floatFormat.format(
                        FuncChequesList.getAvrCost(
                            chequesList.size,
                            totalCost.variable
                        )
                    )
                )
            }
        }
}