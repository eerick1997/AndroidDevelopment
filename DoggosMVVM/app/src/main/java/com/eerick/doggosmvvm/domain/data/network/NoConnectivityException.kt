package com.eerick.doggosmvvm.domain.data.network

import java.io.IOException

class NoConnectivityException : IOException() {
    override val message: String
        get() = "No connectivity Exception"
}