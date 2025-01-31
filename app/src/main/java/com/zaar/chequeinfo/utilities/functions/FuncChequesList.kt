package com.zaar.chequeinfo.utilities.functions

import com.zaar.chequeinfo.data.Primitives
import com.zaar.chequeinfo.model.dataModel.cheque.ChequeModel
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeFormat
import kotlinx.serialization.json.Json

object FuncChequesList {


    fun decodeStrToPojo(string: String, _ignoreUnknownKeys: Boolean) =
        Json { ignoreUnknownKeys = _ignoreUnknownKeys }
            .decodeFromString<List<ChequeModel>>(string)

    fun getCountGoods(chequesList: List<ChequeModel>): Int =
        mutableSetOf<String>().apply {
            chequesList.forEach { cheque ->
                cheque.ticket.document.receipt.items.forEach { good ->
                    add(good.name)
                }
            }
        }.size

    fun getCountSellers(chequesList: List<ChequeModel>) =
        mutableSetOf<String>().apply {
            chequesList.forEach { cheque ->
                add(cheque.ticket.document.receipt.userInn)
            }
        }.size

    fun getCountRecords(chequesList: List<ChequeModel>) =
        run {
            var count = 0
            chequesList.forEach {
                count += it.ticket.document.receipt.items.size
            }
            return@run count
        }

    fun getTotalCost(
        totalCost: Primitives<Float>,
        chequesList: List<ChequeModel>
    ): Float =
        run {
            var sum = 0
            chequesList.forEach { cheque ->
                sum += cheque.ticket.document.receipt.totalSum
            }
            totalCost.variable = sum / 100f
            totalCost.variable
        }


    fun getAvrCost(
        countCheques: Int,
        sumCheques: Float
    ): Float = when {
        countCheques > 0 -> sumCheques / countCheques
        else -> 0f
    }


    fun getCountCheques(chequesList: List<ChequeModel>) =
        chequesList.size


    fun getFirstDay(
        chequeModels: List<ChequeModel>,
        formatter: DateTimeFormat<LocalDateTime>
    ) = run {
        var firstDateTime: LocalDateTime? = null
        chequeModels.forEach { cheque ->
            firstDateTime =
                when (firstDateTime) {
                    null -> cheque.ticket.document.receipt.dateTime
                    else -> {
                        val result = cheque.ticket.document.receipt.dateTime?.let {
                            firstDateTime!!.compareTo(it)
                        }
                        when {
                            result == null -> null
                            result < 0 -> firstDateTime
                            result > 0 -> cheque.ticket.document.receipt.dateTime
                            else -> firstDateTime
                        }
                    }
                }
        }
        val res = firstDateTime?.format(formatter)
            ?: "00.00.0000"
        res
    }


    fun getLastDay(
        chequeModels: List<ChequeModel>,
        formatter: DateTimeFormat<LocalDateTime>
    ) = run {
        var lastDateTime: LocalDateTime? = null
        chequeModels.forEach { cheque ->
            lastDateTime =
                when (lastDateTime) {
                    null -> cheque.ticket.document.receipt.dateTime
                    else -> {
                        val result = cheque.ticket.document.receipt.dateTime?.let {
                            lastDateTime!!.compareTo(it)
                        }
                        when {
                            result == null -> null
                            result > 0 -> lastDateTime
                            result < 0 -> cheque.ticket.document.receipt.dateTime
                            else -> lastDateTime
                        }
                    }
                }
        }
        lastDateTime?.format(formatter)
            ?: "00.00.0000"
    }
}