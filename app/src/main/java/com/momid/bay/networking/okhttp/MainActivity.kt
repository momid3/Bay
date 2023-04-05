//package com.momid.bay.networking.okhttp
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import com.momid.bay.networking.utils.getBaySocketInterface
//import okhttp3.*
//import okio.ByteString
//import java.util.concurrent.TimeUnit
//
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//
//        val client: OkHttpClient = OkHttpClient.Builder()
//            .readTimeout(0, TimeUnit.MILLISECONDS)
//            .build()
//
//        val request: Request = Request.Builder()
//            .url("wss://dev-maestro.rouztech.com/ws/?token=eyJhbGciOiJIUzI1NiIsImlhdCI6MTY4MDU5NDA2MSwiZXhwIjoxNjgwNjgwNDYxfQ.eyJpZCI6ODgsImVtYWlsIjoidGluYS50MmFxQGdtYWlsLmNvbSIsImZpcnN0TmFtZSI6IlRpbmEiLCJsYXN0TmFtZSI6IlRhaG1hc2ViaSIsInRpdGxlIjoiVGluYVRhaG1hc2ViaSIsImF2YXRhciI6Imh0dHBzOi8vZGV2LW1hZXN0cm8ucm91enRlY2guY29tL2Fzc2V0cy9wYW5kYS9pbWFnZXMvYXZhdGFyLTBhYWY2ZGY5LTllYmQtNDE1Yi04MWVjLTg2YzFkMTI4OWQ3Yy5qcGc_X3RzPTE2NDIzMjkyNDkuNjY1OTc4MiIsInJlZmVyZW5jZUlkIjo4NSwic2Vzc2lvbklkIjoiZmI3ZDcxNTgtY2Y0NC00NjkwLTljYmMtY2VlNTBhZmVjZGY0Iiwicm9sZXMiOlsiQWRtaW4iLCJSZXNvdXJjZSIsIlByb2plY3QgTWFlc3RybyIsIlJlbGVhc2UgTWFlc3RybyIsIkxlYWQgUmVzb3VyY2UiXSwib3JnYW5pemF0aW9uSWQiOjl9.hKihGl7rkF60KccJF_WOL8vOdIMAS8is7CFGq5EzONw")
//            .build()
//        client.newWebSocket(request, object : WebSocketListener() {
//            override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
//                println("hia")
//            }
//
//            override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
//                println("hib")
//            }
//
//            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
//                println("hic")
//            }
//
//            override fun onMessage(webSocket: WebSocket, text: String) {
//                println("hid")
//                println(text)
//            }
//
//            override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
//                println("hia")
//            }
//
//            override fun onOpen(webSocket: WebSocket, response: Response) {
//                println("hio")
//                webSocket.send("hi")
//            }
//        })
//
//        val baySocket = getBaySocketInterface()
//
//        println("echo")
//        baySocket.sendEcho("hi")
//
//        baySocket.receiveEcho().subscribe({
//            println("received")
//        }, {
//            it.printStackTrace()
//        })
//
//
//        println("echo")
//        baySocket.sendEcho("hi")
//
//        baySocket.sendEcho("hi")
//
//        baySocket.sendEcho("hi")
//    }
//}
//
//
//
//
//
