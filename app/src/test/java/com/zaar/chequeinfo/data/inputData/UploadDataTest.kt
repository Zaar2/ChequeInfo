package com.zaar.chequeinfo.data.inputData

import android.content.ClipData
import android.content.ClipData.Item
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import com.zaar.chequeinfo.model.dataSource.otherApp.UploadData
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.lang.reflect.Method

@RunWith(MockitoJUnitRunner::class)
class UploadDataTest {



    @Mock
    lateinit var mockContext: Context

    @Mock
    lateinit var mockIntent: Intent

    @Mock
    lateinit var mockClipData: ClipData

    @Mock
    lateinit var mockItemClipData: Item

    @Mock
    lateinit var mockUri: Uri

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        `when`(mockItemClipData.uri).thenReturn(mockUri)
        `when`(mockClipData.itemCount).thenReturn(1)
        `when`(mockClipData.getItemAt(0)).thenReturn(mockItemClipData)
        `when`(mockIntent.action).thenReturn("test")
        `when`(mockIntent.clipData).thenReturn(mockClipData)
        `when`<Uri>(mockIntent.getParcelableExtra("DATA")).thenReturn(mockUri)
    }

    @AfterEach
    fun tearDown() {
        MockitoAnnotations.openMocks(this).close()
    }

    @Test
    fun getUri(){
        val uploadDataTest =
            UploadData(mockIntent, mockContext, mockUri, Build.VERSION_CODES.TIRAMISU)

        val method: Method = UploadData::class.java.getDeclaredMethod("getUri", Intent::class.java)
        method.isAccessible = true
        val uri = method.invoke(uploadDataTest, mockIntent)
        assertTrue(uri == mockUri)
        println("test UploadData().getUri() is OK")

//        verify()
    }

    @Test
    fun getString(){

    }
}