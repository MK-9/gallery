package com.example.camerafeatures

import android.content.Context

interface PermissionCapability {

    fun init(context: Context, permission: String, requestCode: Int)

    fun isDeviceBeforeM(): Boolean

    fun checkPermission(): Boolean

    fun isPermissionDeniedBefore(): Boolean

    fun requestPermission()

    fun permissionGranted()

    fun permissionDenied()

    fun permissionDeniedNeverAskAgain()

    fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    )
}