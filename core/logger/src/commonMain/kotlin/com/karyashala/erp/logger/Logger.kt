package com.karyashala.erp.logger

import com.karyashala.model.network.DataError

interface Logger {
    fun d(tag: String, message: String)
    fun i(tag: String, message: String)
    fun w(tag: String, message: String, error: DataError? = null)
    fun e(tag: String, message: String, error: DataError? = null)
}