package com.example.camerafeatures

import android.app.Activity
import android.content.Intent
import android.provider.MediaStore
import android.widget.Toast

object CameraHelper : BasePermission(){

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
        return false
    }

    private fun startCamera() {
        val intent = Intent()
        intent.action = MediaStore.ACTION_IMAGE_CAPTURE
        with(context as Activity) {
            startActivity(intent)
        }
    }



}