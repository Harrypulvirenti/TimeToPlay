package com.ttp.extensions.android

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

fun AppCompatActivity.isPermissionsGranted(permissions: Array<String>): Boolean =
    permissions.all {
        ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED
    }

fun AppCompatActivity.askPermissions(permissions: Array<String>, requestCode: Int) =
    ActivityCompat.requestPermissions(this, permissions, requestCode)

inline fun AppCompatActivity.doIfPermissionsGrantedOr(
    permissions: Array<String>,
    ifGranted: () -> Unit,
    ifNotGranted: () -> Unit
) {
    if (isPermissionsGranted(permissions)) {
        ifGranted()
    } else {
        ifNotGranted()
    }
}
