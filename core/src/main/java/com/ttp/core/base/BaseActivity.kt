package com.ttp.core.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.ttp.core.R
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module

abstract class BaseActivity(
    @LayoutRes private val layoutId: Int = R.layout.activity_single_fragment
) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoin()
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }

    open fun getKoinModules(): List<Module> = emptyList()

    private fun setupKoin() {
        loadKoinModules(getKoinModules())
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(getKoinModules())
    }
}
