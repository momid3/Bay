package com.momid.bay

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.momid.bay.networking.BaySocketInterface
import com.tinder.scarlet.WebSocket
import io.reactivex.disposables.Disposable
import org.koin.java.KoinJavaComponent.inject

class BayViewModel : ViewModel() {

    private val baySocketInterface : BaySocketInterface by inject(BaySocketInterface::class.java)
    private val _messagesLivedata = MutableLiveData<String>()
    val messagesLiveData : LiveData<String> = _messagesLivedata
    private val disposables = ArrayList<Disposable>()

    init {

        disposables += baySocketInterface.observeOnConnectionOpenedEvent().subscribe {
            println("hi")
            println(it.javaClass)

            if (it is WebSocket.Event.OnConnectionFailed) {
                println(it.throwable.message)
            }

            if (it is WebSocket.Event.OnConnectionOpened<*>) {
                disposables += baySocketInterface.receiveEcho().subscribe {
                    println("received")
                    println(it)
                    _messagesLivedata.postValue(it)
                }
            }
        }
    }

    public fun sendSomeMessage(message: String) {
        baySocketInterface.sendEcho(message)
    }


    override fun onCleared() {
        super.onCleared()
        disposables.forEach {
            it.dispose()
        }
    }
}
