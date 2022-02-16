package com.example.getdatafrominternet.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future

class HomeViewModel : ViewModel() {
    private val image: MutableLiveData<List<String>> by lazy { MutableLiveData<List<String>>() }
    val client by lazy { OkHttpClient() }
    val executors by lazy { Executors.newSingleThreadExecutor() }

    private val request = Request.Builder()
        .url("https://picsum.photos/200/300")
        .build()

    val future: Future<String> = executors.submit(Callable<String> {
        val newCall: Call = client.newCall(request)
        val response: Response = newCall.execute()
        response.body?.string()
    })
    var data: String? = future.get()


}