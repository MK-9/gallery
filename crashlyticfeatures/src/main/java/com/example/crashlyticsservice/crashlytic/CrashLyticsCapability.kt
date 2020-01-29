package com.example.crashlyticsservice.crashlytic

import java.lang.Exception

interface CrashLyticsCapability {

    fun init()

    fun log(message: String)

    fun recordException(exception: Exception)

    fun setPhone(phone: String)

    fun setEmail(email: String)

    fun setUserId(userId: String)

    fun crash()
}