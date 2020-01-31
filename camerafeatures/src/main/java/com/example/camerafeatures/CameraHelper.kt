package com.example.camerafeatures

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.provider.MediaStore
import android.widget.Toast

object CameraHelper : BasePermission() {

    private const val PREF_PERMISSION: String = "PREF_PERMISSION"
    private const val CAMERA_PERMISSION_IS_DENIED: String = "CAMERA_PERMISSION_IS_DENIED"

    override fun permissionGranted() {
        startCamera()
    }

    override fun permissionDenied() {
        requestPermission()
    }

    override fun permissionDeniedNeverAskAgain() {
        Toast.makeText(context, "You should grant camera permission", Toast.LENGTH_LONG).show()
    }

    override fun isPermissionDeniedBefore(): Boolean {
        with(context as Activity) {
            val sharedPreferences = getSharedPreferences(PREF_PERMISSION, Context.MODE_PRIVATE)
            return sharedPreferences.getBoolean(CAMERA_PERMISSION_IS_DENIED, false)
        }
    }

    override fun setPermissionIsDenied(isDenied: Boolean) {
        with(context as Activity) {
            val sharedPreferences = getSharedPreferences(PREF_PERMISSION, Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putBoolean(CAMERA_PERMISSION_IS_DENIED, isDenied)
            editor.apply()
        }
    }

    private fun startCamera() {
        val intent = Intent()
        intent.action = MediaStore.ACTION_IMAGE_CAPTURE
        with(context as Activity) {
            startActivity(intent)
        }
    }


}