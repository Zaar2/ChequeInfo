package com.zaar.chequeinfo.di.component.subComponent

import android.content.Intent
import com.zaar.chequeinfo.model.dataSource.otherApp.OtherAppModuleDI
import com.zaar.chequeinfo.views.activity.uploadCheques.UploadChequesActivity
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class UploadScope

@UploadScope
@Subcomponent(
    modules = [
        OtherAppModuleDI::class,
    ]
)
interface SubCompUploadData {

    @Subcomponent.Factory
    interface UploadDataCompFactory {
        fun create(
            @BindsInstance intent: Intent,
        ): SubCompUploadData
    }


    fun injectUploadActivity(
        uploadChequesActivity: UploadChequesActivity,
    )


//    @Subcomponent.Builder
//    interface UplDataCompBuilder {
//        fun build(): UploadDataComponent
//        @BindsInstance
//        fun context(context: Context): UplDataCompBuilder
//        @BindsInstance
//        fun intentUpl(intent: Intent): UplDataCompBuilder
//    }
}