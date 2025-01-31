package com.zaar.chequeinfo.model.dataSource.otherApp

import android.content.ClipData
import android.content.ClipData.Item
import android.content.Intent
import android.net.Uri
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.zaar.chequeinfo.views.activity.uploadCheques.UploadChequesActivity
import org.junit.Rule
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UploadDataTest {

    private val intent = Intent(
        ApplicationProvider.getApplicationContext(),
        UploadChequesActivity::class.java
    ).apply {
        clipData = ClipData(
            "testText",
            arrayOf("text/html"),
            Item(
                Uri.parse("test test")
            )
        )
        action = "testAction"
    }

    @JvmField
    @Rule
    val activityRule = ActivityScenarioRule<UploadChequesActivity>(intent)


    @BeforeEach
    fun setUp() {

    }

    @Test
    fun getString(){

    }
}