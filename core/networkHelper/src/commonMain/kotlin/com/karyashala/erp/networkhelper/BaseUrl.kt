package com.karyashala.erp.networkhelper


sealed class BaseUrl(open val url: String) {

    data object Generic : BaseUrl("demo_base_url.com")
}