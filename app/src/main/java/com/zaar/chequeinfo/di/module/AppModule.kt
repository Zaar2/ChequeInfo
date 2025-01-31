package com.zaar.chequeinfo.di.module

import com.zaar.chequeinfo.model.dataSource.local.room.database.DatabaseModuleDI
import dagger.Module

@Module(
    includes = [
        DatabaseModuleDI::class,
    ]
)
class AppModule