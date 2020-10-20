package com.ttp.core.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module

abstract class BaseActivity(
    @LayoutRes private val layoutId: Int
) : AppCompatActivity() {

    /**
     * Return, if present, the current [BaseFragment] displayed in the screen.
     * This val should be overridden from the concrete [AppCompatActivity] in order to
     * return the real instance of the current [Fragment] present on the screen.
     *
     * @return [BaseFragment]
     * */
    protected open val currentFragment: BaseFragment? = null

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

    /**
     * This method is allowing the [currentFragment] to handle the onBackPressed event.
     *
     * This method is firstly calling the onBackPressed method of the [BaseFragment] and,
     * if the event is not handled by the fragment, will invoke the super.onBackPressed()
     *
     * @see BaseFragment.onBackPressed
     * @see currentFragment
     * @see AppCompatActivity.onBackPressed
     * */
    override fun onBackPressed() {
        if (currentFragment?.onBackPressed() != true) {
            super.onBackPressed()
        }
    }
}
