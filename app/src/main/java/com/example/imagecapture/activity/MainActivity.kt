package com.example.imagecapture.activity

import android.Manifest
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.camerafeatures.CameraHelper
import com.example.imagecapture.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val button = Button(this)
        addContentView(button, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100))
        button.setOnClickListener {
            CameraHelper.init(this, Manifest.permission.CAMERA, 1122)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                1122 -> {
                    Toast.makeText(this, "1122", Toast.LENGTH_SHORT).show()
                }

                2233 -> {

                }
            }
        } else if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(this, "RESULT_CANCELED", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        CameraHelper.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

}
