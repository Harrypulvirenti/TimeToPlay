package com.ttp.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle

interface ActivityNavigator : Navigator {

    val context: Context

    fun Intent.navigateTo(bundle: Bundle? = null) = context.startActivity(this, bundle)
}
