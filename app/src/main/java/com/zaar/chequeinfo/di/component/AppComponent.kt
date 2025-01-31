package com.zaar.chequeinfo.di.component

import android.content.Context
import com.zaar.chequeinfo.di.module.AppModule
import com.zaar.chequeinfo.di.component.subComponent.SubCompUploadData
import com.zaar.chequeinfo.model.repository.LocalDbRepositoryImpl
import com.zaar.chequeinfo.views.fragment.mainMenu.MainMenuFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        AppModule::class,
    ],
)
interface AppComponent {

    @Component.Factory
    interface AppCompFactory {
        fun create(
            @BindsInstance context: Context,
            appModule: AppModule,
        ): AppComponent
    }

    //subcomponents
    fun getSubCompUploadDataFactory(): SubCompUploadData.UploadDataCompFactory

    //inject
    fun injectLocalDbRepository(localDbRepositoryImpl: LocalDbRepositoryImpl)
    fun injectMainMenuFragment(mainMenuFragment: MainMenuFragment)
}