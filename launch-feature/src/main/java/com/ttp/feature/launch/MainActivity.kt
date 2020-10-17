package com.ttp.feature.launch

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.ttp.core.base.BaseActivity
import com.ttp.core.base.BaseFragment
import com.ttp.navigation.extensions.currentChildFragment
import com.ttp.navigation.extensions.setupMainGraph
import kotlinx.android.synthetic.main.activity_main.*

internal class MainActivity : BaseActivity(R.layout.activity_main) {

    override val currentFragment: BaseFragment?
        get() = (navHostFragment?.currentChildFragment as? BaseFragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupMainGraph(navHostFragment.findNavController(), R.navigation.main_nav_graph)
    }
}