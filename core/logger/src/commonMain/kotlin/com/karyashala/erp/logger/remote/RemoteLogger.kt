package com.karyashala.erp.logger.remote

import com.karyashala.erp.logger.LogEntry

interface RemoteLogger {
    suspend fun sendLogs(logs: List<LogEntry>)
}