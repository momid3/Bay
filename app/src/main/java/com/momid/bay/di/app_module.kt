package com.momid.bay.di

import com.momid.bay.networking.utils.getBaySocketInterface
import com.momid.bay.networking.utils.getScarletInstance
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.momid.bay.BayViewModel

val appModule = module {

    factory {
        getScarletInstance(androidApplication())
    }

    factory {
        getBaySocketInterface(get())
    }

    viewModelOf(::BayViewModel)
}
