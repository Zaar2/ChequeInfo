package com.zaar.chequeinfo.model.dataSource.otherApp

import android.content.Context
import android.content.Intent
import com.zaar.chequeinfo.di.component.subComponent.UploadScope
import dagger.Module
import dagger.Provides

@Module
class OtherAppModuleDI{

//    @UploadScope
//    @Provides
//    fun provideParsedData(uploadData: UploadData): ParsedData {
//        return ParsedData(uploadData)
//    }

    @UploadScope
    @Provides
    fun provideUploadData(context: Context, intentUpload: Intent): UploadData {
        return UploadData(
            intentUpload,
            context,
        )
    }
}