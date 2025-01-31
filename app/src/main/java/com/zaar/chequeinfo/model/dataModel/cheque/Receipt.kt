package com.zaar.chequeinfo.model.dataModel.cheque

import androidx.room.Embedded
import androidx.room.Ignore
import com.zaar.chequeinfo.utilities.serializers.DateTimeSerializer
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("receipt")
data class Receipt(
    var buyerPhoneOrAddress: String = "",
    var cashTotalSum: Int = 0,
    var code: Int = -1,
    var creditSum: Int = 0,
    @Serializable(with = DateTimeSerializer::class)
    var dateTime: LocalDateTime? = null,
    var ecashTotalSum: Int = 0,
    var fiscalDocumentFormatVer: Int = -1,
    var fiscalDocumentNumber: Long = -1L,
    var fiscalDriveNumber: String = "",
    var fiscalSign: Long = -1L,
    var internetSign: Int = -1,
    var fnsUrl: String = "",

    var kktRegId: String = "",
    var machineNumber: String = "",
    var ndsNo: Int = 0,
    var nds10: Int = 0,
    var nds18: Int = 0,
    var operationType: Int = -1,
    var operator: String = "",
    var operatorInn: String = "",
    var prepaidSum: Int = 0,
    @Embedded
    var properties: Properties = Properties(),
    var propertiesData: String = "",
    var provisionSum: Int = 0,
    var requestNumber: Int = -1,
    var retailPlace: String = "",
    var retailPlaceAddress: String = "",
    var sellerAddress: String = "",
    var shiftNumber: Int = -1,
    var taxationType: Int = -1,
    var appliedTaxationType: Int = -1,
    var totalSum: Int = 0,
    var user: String = "",
    var userInn: String = "",

    @Ignore
    var items: List<Item> = emptyList()
)