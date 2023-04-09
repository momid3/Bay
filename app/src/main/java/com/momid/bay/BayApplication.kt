package com.momid.bay

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BayApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@BayApplication)
            // Load modules
            modules(com.momid.bay.di.appModule)
        }
    }
}
