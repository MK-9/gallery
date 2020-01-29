package com.example.crashlyticsservice.crashlytic

import com.google.firebase.crashlytics.FirebaseCrashlytics
import java.lang.Exception

object CrashLyticsHelper : CrashLyticsCapability {

    lateinit var instance: FirebaseCrashlytics

    override fun init() {
        instance = FirebaseCrashlytics.getInstance()
    }

    override fun log(message: String) {
        if (::instance.isInitialized) {
            instance.log(message)
        }
    }

    override fun recordException(exception: Exception) {
        if (::instance.isInitialized) {
            instance.recordException(exception)
        }
    }

    override fun setPhone(phone: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setEmail(email: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setUserId(userId: String) {
        if (::instance.isInitialized) {
            instance.setUserId(userId)
        }
    }

    override fun crash() {
        if (::instance.isInitialized) {
            throw RuntimeException("Test Crash")
        }
    }


}