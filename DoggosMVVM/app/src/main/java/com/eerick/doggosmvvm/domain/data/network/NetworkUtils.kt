package com.eerick.doggosmvvm.domain.data.network

import android.content.Context
import android.net.ConnectivityManager

class NetworkUtils {
    companion object {
        fun isOnline(context: Context) : Boolean {
            val connectivityManager: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return (networkInfo != null && networkInfo.isConnected)
        }
    }
}