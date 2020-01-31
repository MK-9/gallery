package com.example.crashlyticsservice.analytics

import android.app.Activity
import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

object AnalyticsHelper : AnalyticsCapability {

    lateinit var analytics: FirebaseAnalytics

    override fun init(context: Context) {
        if (::analytics.isInitialized) {
            analytics = FirebaseAnalytics.getInstance(context)
        }
    }

    override fun logEvent(id: String, name: String, contentType: String) {
        if (::analytics.isInitialized) {
            val bundle = Bundle()
            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id)
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name)
            bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, contentType)
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
        }
    }

    override fun setUserId(userID: String?) {
        if (::analytics.isInitialized) {
            analytics.setUserId(userID)
        }
    }

    override fun setUserProperty(key: String, value: String) {
        if (::analytics.isInitialized) {
            analytics.setUserProperty(key, value)
        }
    }

    override fun setCurrentScreen(activity: Activity, key: String, value: String) {
        if (::analytics.isInitialized) {
            analytics.setCurrentScreen(activity, key, value)
        }
    }
}