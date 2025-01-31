package com.zaar.chequeinfo.views.activity.uploadCheques

import android.content.Intent
import android.nfc.NfcAdapter
import android.security.KeyChain
import androidx.test.rule.ActivityTestRule

open class UplActTestRule (activityClass: Class<UploadChequesActivity>)
    : ActivityTestRule<UploadChequesActivity>(activityClass) {

    override fun getActivityIntent(): Intent {
        val intent = Intent()
        intent.putExtra(NfcAdapter.EXTRA_ID, 3)
        intent.putExtra(KeyChain.EXTRA_NAME, "Name 3")
        return intent
    }

    override fun beforeActivityLaunched() {
        super.beforeActivityLaunched()
        println("beforeActivityLaunched")
    }

    override fun afterActivityLaunched() {
        super.afterActivityLaunched()
        println("afterActivityLaunched")
    }

    override fun afterActivityFinished() {
        super.afterActivityFinished()
        println("afterActivityFinished")
    }
}