package ru.codavari.rickandmortyapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ru.codavari.rickandmortyapp.MobileApplication
import ru.codavari.rickandmortyapp.activity.AppActivityGlobalModule
import ru.codavari.rickandmortyapp.ui.UIModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    RepositoryModule::class,
    NetworkModule::class,
    ApiModule::class,
    AppActivityGlobalModule::class,
    ApplicationContextModule::class,
    UIModule::class,
    AndroidInjectionModule::class,
])
interface AppComponent : AndroidInjector<MobileApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent

        fun applicationContextModule(module: ApplicationContextModule): Builder
    }
}