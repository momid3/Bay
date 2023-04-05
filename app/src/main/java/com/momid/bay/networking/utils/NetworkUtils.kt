package com.momid.bay.networking.utils

import com.momid.bay.networking.BaySocketInterface
import com.tinder.scarlet.Scarlet
import com.tinder.scarlet.messageadapter.gson.GsonMessageAdapter
import com.tinder.scarlet.streamadapter.rxjava2.RxJava2StreamAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import com.tinder.scarlet.websocket.okhttp.newWebSocketFactory

public fun getScarletInstance(): Scarlet {

    return Scarlet.Builder()
        .webSocketFactory(OkHttpClient.Builder().build().newWebSocketFactory("wss://dev-maestro.rouztech.com/ws/?token=eyJhbGciOiJIUzI1NiIsImlhdCI6MTY4MDU5NDA2MSwiZXhwIjoxNjgwNjgwNDYxfQ.eyJpZCI6ODgsImVtYWlsIjoidGluYS50MmFxQGdtYWlsLmNvbSIsImZpcnN0TmFtZSI6IlRpbmEiLCJsYXN0TmFtZSI6IlRhaG1hc2ViaSIsInRpdGxlIjoiVGluYVRhaG1hc2ViaSIsImF2YXRhciI6Imh0dHBzOi8vZGV2LW1hZXN0cm8ucm91enRlY2guY29tL2Fzc2V0cy9wYW5kYS9pbWFnZXMvYXZhdGFyLTBhYWY2ZGY5LTllYmQtNDE1Yi04MWVjLTg2YzFkMTI4OWQ3Yy5qcGc_X3RzPTE2NDIzMjkyNDkuNjY1OTc4MiIsInJlZmVyZW5jZUlkIjo4NSwic2Vzc2lvbklkIjoiZmI3ZDcxNTgtY2Y0NC00NjkwLTljYmMtY2VlNTBhZmVjZGY0Iiwicm9sZXMiOlsiQWRtaW4iLCJSZXNvdXJjZSIsIlByb2plY3QgTWFlc3RybyIsIlJlbGVhc2UgTWFlc3RybyIsIkxlYWQgUmVzb3VyY2UiXSwib3JnYW5pemF0aW9uSWQiOjl9.hKihGl7rkF60KccJF_WOL8vOdIMAS8is7CFGq5EzONw"))
        .addMessageAdapterFactory(GsonMessageAdapter.Factory())
        .addStreamAdapterFactory(RxJava2StreamAdapterFactory())
        .build()
}

public fun getBaySocketInterface(): BaySocketInterface {
    return getScarletInstance().create()
}
