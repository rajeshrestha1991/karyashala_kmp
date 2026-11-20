package com.karyashala.erp.components.media

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import com.karyashala.erp.components.permissions.GALLERY_PERMISSION
import com.karyashala.erp.components.permissions.GALLERY_PERMISSION_LIMITED
import org.koin.mp.KoinPlatform.getKoin

actual fun checkGalleryFullAccess(): Boolean {
    val context: Context = getKoin().get()
    return ContextCompat.checkSelfPermission(context, GALLERY_PERMISSION) ==
            PackageManager.PERMISSION_GRANTED
}

actual fun checkGalleryLimitAccess(): Boolean {
    val context: Context = getKoin().get()
    return ContextCompat.checkSelfPermission(context, GALLERY_PERMISSION_LIMITED) ==
            PackageManager.PERMISSION_GRANTED
}