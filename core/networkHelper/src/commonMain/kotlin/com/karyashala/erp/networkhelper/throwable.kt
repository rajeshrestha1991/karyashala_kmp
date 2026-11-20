package com.karyashala.erp.networkhelper

import com.karyashala.model.network.DataError

expect fun Throwable.toNetworkError(): DataError.NetworkError