package com.zaar.chequeinfo.model.dataModel.cheque

import com.zaar.chequeinfo.utilities.serializers.DateTimeUtcSerializer
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.serialization.Serializable

/**
 * @param createdAt date of create of the cheque, by UTC (+00.00)
 * @param user_data tag for the cheque, set by the user.
 * If the user not set this tag, then UserData.title contains an empty string
 */

@Serializable
data class ChequeModel(
    var _id: String = "",
    @Serializable(with = DateTimeUtcSerializer::class)
    val createdAt: DateTimeComponents? = null,
    val ticket: Ticket = Ticket(),
    var user_data: UserData = UserData()
)
