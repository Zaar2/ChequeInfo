package com.zaar.chequeinfo.model.repository

import android.content.Context
import com.zaar.chequeinfo.app.App
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LocalDbRepositoryImplTest {

    @Mock
    lateinit var mockContext: Context


    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @AfterEach
    fun tearDown() {
        MockitoAnnotations.openMocks(this).close()
    }

    @Test
    fun getDb() {
//        val repositoryLocalDb = LocalDbRepositoryImpl(mockContext)
//        assertTrue(repositoryLocalDb.db != null)
    }

    @Test
    fun setDb() {
    }

    @Test
    fun setChequesModel() {
    }

    @Test
    fun getAllChequesModel() {
    }

    @Test
    fun getAllTbl() {
    }
}