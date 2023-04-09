package com.momid.bay.networking

import com.momid.bay.EchoModel
import com.tinder.scarlet.WebSocket
import com.tinder.scarlet.ws.Receive
import com.tinder.scarlet.ws.Send
import io.reactivex.Flowable
import io.reactivex.Observable

interface BaySocketInterface {
    @Send
    public fun sendEcho(echoModel: String)

    @Receive
    public fun receiveEcho() : Flowable<String>

    @Receive
    fun observeOnConnectionOpenedEvent(): Flowable<WebSocket.Event>
}


