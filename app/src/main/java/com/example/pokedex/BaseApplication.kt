package com.example.pokedex

import android.app.Application
import com.example.pokedex.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(listOf(
                viewModelModule,
                retrofitModule,
                apiModule,
                repositoryModule,
                databaseModule
            ))
        }
    }
}