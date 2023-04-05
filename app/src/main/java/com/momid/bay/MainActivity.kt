package com.momid.bay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.momid.bay.networking.utils.getBaySocketInterface

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val baySocket = getBaySocketInterface()

        Handler().postDelayed({

            println("echo")
            baySocket.sendEcho("hi")

            baySocket.receiveEcho().subscribe({
                println("received")
            }, {
                it.printStackTrace()
            })


            println("echo")
            baySocket.sendEcho("hi")

            baySocket.sendEcho("hi")

            baySocket.sendEcho("hi")
        }, 17000)
    }
}





