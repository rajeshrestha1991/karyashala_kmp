package com.karyashala.erp.logger.remote

import com.karyashala.erp.logger.LogEntry

class FirebaseLogger : RemoteLogger {
    override suspend fun sendLogs(logs: List<LogEntry>) {
        println("logs $logs")
    }
}