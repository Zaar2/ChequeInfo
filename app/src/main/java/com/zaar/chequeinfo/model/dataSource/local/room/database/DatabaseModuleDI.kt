package com.zaar.chequeinfo.model.dataSource.local.room.database

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class DatabaseModuleDI {

    @Provides
    fun provideDatabase(context: Context): DatabaseChequeInf =
        DatabaseChequeInf.getInstance(context)
}