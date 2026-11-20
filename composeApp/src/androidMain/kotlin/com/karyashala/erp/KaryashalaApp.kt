package com.karyashala.erp

import android.app.Application
import com.karyashala.di.androidKoinInit
import com.karyashala.erp.logger.setupLogger

class KaryashalaApp : Application() {

    override fun onCreate() {
        super.onCreate()
        androidKoinInit(this@KaryashalaApp)
        setupLogger("Android")
    }


}