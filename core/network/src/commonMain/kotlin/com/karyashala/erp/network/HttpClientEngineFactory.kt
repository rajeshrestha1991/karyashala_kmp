package com.karyashala.erp.network

import io.ktor.client.engine.HttpClientEngine

expect class HttpClientEngineFactory(){
    fun getHttpEngine(): HttpClientEngine
}