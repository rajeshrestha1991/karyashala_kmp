package com.karyashala.erp.components.device_info

import com.karyashala.model.device_info.DeviceInfo

expect fun getDeviceInfo(): DeviceInfo
expect fun getDeviceUniqueIdentifier(): String