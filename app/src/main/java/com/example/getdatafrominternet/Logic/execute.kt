package com.example.getdatafrominternet

import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okio.IOException
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future

fun main() {
    val client by lazy { OkHttpClient() }
    val executors by lazy { Executors.newSingleThreadExecutor() }

    val request = Request.Builder()
        .url("https://picsum.photos/200/300")
        .build()

    try {
        val future: Future<String> = executors.submit(Callable<String> {
            val newCall: Call = client.newCall(request)
            val response: Response = newCall.execute()
            response.body?.string()
        })
        val data: String? = future.get()
        println(data)

    } catch (e: IOException) {
        e.javaClass.simpleName
    }
}