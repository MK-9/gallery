package com.example.crashlyticsservice.analytics

import android.app.Activity
import android.content.Context

interface AnalyticsCapability {

    fun init(context: Context)

    fun logEvent(id: String, name: String, contentType: String)

    fun setUserId(userID: String?)

    fun setUserProperty(key: String, value: String)

    fun setCurrentScreen(activity: Activity, key: String, value: String)
}