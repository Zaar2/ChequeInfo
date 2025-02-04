package com.zaar.chequeinfo.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zaar.chequeinfo.data.Primitives
import com.zaar.chequeinfo.model.dataModel.cheque.ChequeModel
import com.zaar.chequeinfo.utilities.functions.FuncChequesList
import com.zaar.chequeinfo.utilities.serializers.FormatterLocalDateTime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format.DateTimeFormat
import java.text.DecimalFormat
import java.util.concurrent.atomic.AtomicInteger

open class BaseViewModelSummarizedInf : ViewModel() {

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

    protected var mldMapResult = MutableLiveData<Map<Int, Int>>()
    fun ldMapResult(): LiveData<Map<Int, Int>> = mldMapResult

    protected val mldIsProgress = MutableLiveData<Boolean>()
    fun ldIsProgress(): LiveData<Boolean> = mldIsProgress

    protected val mldSetProgress = MutableLiveData<Int>()
    fun ldSetProgress(): LiveData<Int> = mldSetProgress

    var countMaxProgressBar = -1
        set(value) {
            if (value > 0) {
                mldSetProgress.postValue(0)
            }
            field = value
        }
    protected var currentProgress: AtomicInteger = AtomicInteger(0)

    private var formatter: DateTimeFormat<LocalDateTime> = FormatterLocalDateTime.formatterDate

    private val floatFormat = DecimalFormat("#,###,##0.00")
    private val integerFormat = DecimalFormat("#,###,##0")

    protected suspend fun getSummarizedInformation(chequesList: List<ChequeModel>) =
        withContext(Dispatchers.IO) {
            currentProgress.set(0)
            val totalCost: Primitives<Float> = Primitives(0f)
            launch {
                mldFirstDay.postValue(
                    FuncChequesList.getFirstDay(
                        chequesList,
                        formatter
                    ).takeIf { it.isNotEmpty() }?.apply {
                        incrementProgress()
                    } ?: ""
                )
            }
            launch {
                mldCountRecords.postValue(
                    integerFormat.format(
                        FuncChequesList.getCountRecords(chequesList)
                            .takeIf { it != 0 }?.apply {
                                incrementProgress()
                            } ?: 0
                    )
                )
            }
            launch {
                mldLastDay.postValue(
                    FuncChequesList.getLastDay(
                        chequesList,
                        formatter
                    ).takeIf { it.isNotEmpty() }?.apply {
                        incrementProgress()
                    } ?: ""
                )
            }
            launch {
                mldCountCheques.postValue(
                    integerFormat.format(
                        FuncChequesList.getCountCheques(chequesList)
                    ).takeIf { it.isNotEmpty() }?.apply {
                        incrementProgress()
                    } ?: ""
                )
            }
            launch {
                mldCountGoods.postValue(
                    integerFormat.format(
                        FuncChequesList.getCountGoods(chequesList)
                    ).takeIf { it.isNotEmpty() }?.apply {
                        incrementProgress()
                    } ?: ""
                )
            }
            launch {
                mldCountSellers.postValue(
                    integerFormat.format(
                        FuncChequesList.getCountSellers(chequesList)
                    ).takeIf { it.isNotEmpty() }?.apply {
                        incrementProgress()
                    } ?: ""
                )
            }

            val jobTotalCost = launch {
                mldTotalCost.postValue(
                    floatFormat.format(
                        FuncChequesList.getTotalCost(
                            totalCost,
                            chequesList
                        )
                    ).takeIf { it.isNotEmpty() }?.apply {
                        incrementProgress()
                    } ?: ""
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
                    ).takeIf { it.isNotEmpty() }?.apply {
                        incrementProgress()
                    } ?: ""
                )
            }
        }

    private fun incrementProgress() {
        val progress = currentProgress.incrementAndGet()
        mldSetProgress.postValue(progress)
        if (progress >= countMaxProgressBar)
            mldIsProgress.postValue(false)
    }
}