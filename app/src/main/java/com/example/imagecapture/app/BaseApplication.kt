package com.example.imagecapture.app

import android.app.Application
import com.example.crashlyticsservice.crashlytic.CrashLyticsHelper

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        CrashLyticsHelper.init()
    }
}