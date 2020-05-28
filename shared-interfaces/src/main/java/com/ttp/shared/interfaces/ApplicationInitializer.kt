package com.ttp.shared.interfaces

import android.content.Context

interface ApplicationInitializer

data class ApplicationBundle(val applicationContext: Context, val isDebug: Boolean)
