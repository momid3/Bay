package com.momid.bay.networking.utils

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import com.momid.bay.networking.BaySocketInterface
import com.tinder.scarlet.Scarlet
import com.tinder.scarlet.lifecycle.android.AndroidLifecycle
import com.tinder.scarlet.messageadapter.gson.GsonMessageAdapter
import com.tinder.scarlet.streamadapter.rxjava2.RxJava2StreamAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import com.tinder.scarlet.websocket.okhttp.newWebSocketFactory

public fun getScarletInstance(application: Application): Scarlet {

    return Scarlet.Builder()
        .webSocketFactory(OkHttpClient.Builder().build().newWebSocketFactory("wss://socketsbay.com/wss/v2/1/demo/"))
//        .addMessageAdapterFactory(GsonMessageAdapter.Factory())
        .addStreamAdapterFactory(RxJava2StreamAdapterFactory())
        .lifecycle(AndroidLifecycle.ofApplicationForeground(application))
        .build()
}

public fun getBaySocketInterface(scarlet: Scarlet): BaySocketInterface {
    return scarlet.create()
}
