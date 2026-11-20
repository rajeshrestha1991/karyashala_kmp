package com.karyashala.erp.networkhelper


import com.karyashala.model.network.DataError
import java.net.SocketTimeoutException
import java.net.UnknownHostException

actual fun Throwable.toNetworkError(): DataError.NetworkError {
    return when (this) {
        is UnknownHostException -> DataError.NetworkError.NoInternet
        is SocketTimeoutException -> DataError.NetworkError.RequestTimeout
        else -> DataError.NetworkError.DataUnknown
    }
}