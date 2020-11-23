package com.gzeinnumer.checkinternetkt

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity_"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //android 9 ke bawah
//        startNetworkCalilback()

        //android 10 -> realtime
        startNetworkCalilback10()
    }

    private fun startNetworkCalilback() {
        val cm: ConnectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val isConnect: Boolean =  cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected

        Log.d(TAG, "startNetworkCalilback: $isConnect")
    }

    private fun startNetworkCalilback10() {
        val cm: ConnectivityManager = application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val builder: NetworkRequest.Builder = NetworkRequest.Builder()

        cm.registerNetworkCallback(builder.build(),
            object : ConnectivityManager.NetworkCallback() {

                override fun onAvailable(network: Network) {
                    Log.d(TAG, "onAvailable: true")
                }

                override fun onLost(network: Network) {
                    Log.d(TAG, "onAvailable: false")
                }
            })
    }
}