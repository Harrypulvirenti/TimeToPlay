package com.ttp.extensions.android

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

inline fun <reified T : Fragment> FragmentActivity.replaceFragment(
    @IdRes containerId: Int,
    args: Bundle? = null,
    tag: String = T::class.java.simpleName
) =
    supportFragmentManager.beginTransaction()
        .replace(containerId, T::class.java, args, tag)
        .commit()

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
