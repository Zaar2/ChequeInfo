package com.zaar.chequeinfo.views.activity.uploadCheques

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zaar.chequeinfo.R
import com.zaar.chequeinfo.data.Primitives
import com.zaar.chequeinfo.model.dataModel.cheque.ChequeModel
import com.zaar.chequeinfo.model.dataSource.otherApp.ParsedData
import com.zaar.chequeinfo.model.repository.LocalDbRepositoryImpl
import com.zaar.chequeinfo.utilities.functions.FuncChequesList
import com.zaar.chequeinfo.utilities.serializers.FormatterLocalDateTime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format.DateTimeFormat
import java.text.DecimalFormat

class UploadChequesViewModel(
    private val context: Context,
    private val parsedData: ParsedData,
) : ViewModel() {

    private val chequesList: List<ChequeModel> = parsedData.chequeModels

//    private val mldCheques = MutableLiveData<List<ChequeModel>>()
//    fun ldCheques(): LiveData<List<ChequeModel>> = mldCheques
//
//    private val mldTbls = MutableLiveData<List<String>>()
//    fun ldTbls(): LiveData<List<String>> = mldTbls

    private var mldFirstDay = MutableLiveData<String>()
    fun ldFirstDay(): LiveData<String> = mldFirstDay

    private var mldLastDay = MutableLiveData<String>()
    fun ldLastDay(): LiveData<String> = mldLastDay

    private var mldCountGoods = MutableLiveData<String>()
    fun ldCountGoods(): LiveData<String> = mldCountGoods

    private var mldCountCheques = MutableLiveData<String>()
    fun ldCountCheques(): LiveData<String> = mldCountCheques

    private var mldCountRecords = MutableLiveData<String>()
    fun ldCountRecords(): LiveData<String> = mldCountRecords

    private var mldCountSellers = MutableLiveData<String>()
    fun ldCountSellers(): LiveData<String> = mldCountSellers

    private var mldTotalCost = MutableLiveData<String>()
    fun ldTotalCost(): LiveData<String> = mldTotalCost

    private var mldAvrCost = MutableLiveData<String>()
    fun ldAvrCost(): LiveData<String> = mldAvrCost

    private var mldMapResult = MutableLiveData<Map<Int, Int>>()
    fun ldMapResult(): LiveData<Map<Int, Int>> = mldMapResult

    private var formatter: DateTimeFormat<LocalDateTime> = FormatterLocalDateTime.formatterDate

    private val floatFormat = DecimalFormat("#,###,##0.00")
    private val integerFormat = DecimalFormat("#,###,##0")


    fun getSummarizedInformation() =
        viewModelScope.launch(Dispatchers.IO) {
            val totalCost: Primitives<Float> = Primitives(0f)
            launch {
                mldFirstDay.postValue(
                    FuncChequesList.getFirstDay(
                        parsedData.chequeModels,
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
                        parsedData.chequeModels,
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

    fun saveCheques() {
        viewModelScope.launch(Dispatchers.IO) {
            LocalDbRepositoryImpl(context).apply {
                val map = setChequesModel(chequesModel = chequesList)
                val chequeRejected = chequesList.size -
                        map.getOrDefault(R.string.lblChequesUploaded, 0)
                map[R.string.lblChequesRejected] = chequeRejected
                mldMapResult.postValue(map)
//                val cheques = getAllChequesModel()
//                val tbls = getAllTbl()
//                mldTbls.postValue(tbls)
//                mldCheques.postValue(cheques)

            }
        }
    }
}