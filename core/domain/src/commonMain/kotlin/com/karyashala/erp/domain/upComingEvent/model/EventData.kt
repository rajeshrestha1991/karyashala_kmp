package com.karyashala.erp.domain.upComingEvent.model

data class EventData(
    val name : String,
    val description: String,
    val isNotice: String,
    val fromDateBs : String,
    val toDateBs: String
)
