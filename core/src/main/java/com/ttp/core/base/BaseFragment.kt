package com.ttp.core.base

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module

abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {

    override fun onAttach(context: Context) {
        setupKoin()
        super.onAttach(context)
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
