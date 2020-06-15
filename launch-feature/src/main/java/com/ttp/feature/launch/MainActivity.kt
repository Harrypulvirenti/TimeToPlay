package com.ttp.feature.launch

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.ttp.core.base.BaseActivity
import com.ttp.navigation.extensions.setupNavigation
import kotlinx.android.synthetic.main.activity_main.*

internal class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupNavigation(navHostFragment.findNavController(), R.navigation.main_nav_graph)
    }
}