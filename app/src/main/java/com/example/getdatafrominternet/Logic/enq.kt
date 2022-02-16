package com.example.getdatafrominternet.Logic

import android.os.Handler
import okhttp3.*
import java.io.IOException

fun main() {
    val client by lazy { OkHttpClient() }
    val request: Request = Request.Builder()
        .url("https://picsum.photos/200/300")
        .build()

    val newCall: Call = client.newCall(request)
    newCall.enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            TODO("Not yet implemented")
        }

        override fun onResponse(call: Call, response: Response) {
            response.body?.string()
        }

    })
}
//private fun setResualt(data: String?){
//    Handler(mainLooper).post {
//        XXX
//    }
//}
/**
 * OR
 */
/**
 * private fun setResualt(data: String?){
runOnUiThread {
xxx
}
}
 */