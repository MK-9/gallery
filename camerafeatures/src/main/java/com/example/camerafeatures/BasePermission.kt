package com.example.camerafeatures

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat

abstract class BasePermission : PermissionCapability {

    lateinit var context: Context
    lateinit var permission: String
    var requestCode: Int = 0

    override fun init(context: Context, permission: String, requestCode: Int) {
        this.context = context
        this.permission = permission
        this.requestCode = requestCode
        init()
    }

    private fun init() {
        when {
            isDeviceBeforeM() -> {
                permissionGranted()
            }

            checkPermission() -> {
                permissionGranted()
            }

            ActivityCompat.shouldShowRequestPermissionRationale(
                context as Activity,
                permission
            ) -> {
                permissionDenied()
            }

            isPermissionDeniedBefore() -> {
                permissionDeniedNeverAskAgain()
            }

            else -> {
                requestPermission()
            }
        }
    }

    override fun isDeviceBeforeM(): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M
    }

    override fun checkPermission(): Boolean {
        return ActivityCompat.checkSelfPermission(context, permission) ==
                PackageManager.PERMISSION_GRANTED
    }

    override fun requestPermission(
    ) {
        ActivityCompat.requestPermissions(context as Activity, Array(1) { permission }, requestCode)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            1122 -> {
                if (grantResults.isNotEmpty()) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        setPermissionIsDenied(false)
                        permissionGranted()
                    } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                        setPermissionIsDenied(true)
                    }
                }
            }
        }
    }
}