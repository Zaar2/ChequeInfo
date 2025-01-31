package com.zaar.chequeinfo.app

import android.app.Application
import com.zaar.chequeinfo.di.component.AppComponent
import com.zaar.chequeinfo.di.component.DaggerAppComponent
import com.zaar.chequeinfo.di.module.AppModule

class App : Application() {

    companion object {
        private lateinit var appComponent: AppComponent

        fun getAppComponent(): AppComponent = appComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory()
            .create(
                applicationContext,
                AppModule(),
            )
    }


}