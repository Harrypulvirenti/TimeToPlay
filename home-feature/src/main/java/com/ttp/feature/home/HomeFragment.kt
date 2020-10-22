package com.ttp.feature.home

import android.os.Bundle
import android.view.View
import androidx.navigation.NavDestination
import androidx.navigation.ui.setupWithNavController
import com.ttp.core.base.BaseFragment
import com.ttp.core.extensions.viewBinding
import com.ttp.extensions.android.handleOnBackPressed
import com.ttp.extensions.kotlin.lazyFast
import com.ttp.feature.home.databinding.FragmentHomeBinding
import com.ttp.navigation.HomeBottomNavigation
import com.ttp.navigation.extensions.findChildNavController
import com.ttp.navigation.extensions.setupSubGraph

internal class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val childNavController by lazyFast { findChildNavController(R.id.bottomBarNavHostFragment) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSubGraph<HomeBottomNavigation>(
            childNavController,
            R.navigation.home_bottom_bar_navigation
        )

        setupBottomNavigationView()

        handleOnBackPressed {
            childNavController.popBackStack().also {
                updateBottomViewPosition(childNavController.currentDestination)
            }
        }
    }

    private fun setupBottomNavigationView() {
        binding.bottomNavView.setupWithNavController(childNavController)
        binding.bottomNavView.setOnNavigationItemSelectedListener {
            childNavController.navigate(it.itemId)
            true
        }
    }

    private fun updateBottomViewPosition(navDestination: NavDestination?) {
        val selectedMenuId = when (navDestination?.id) {
            R.id.discoveryFragment -> R.id.toDiscoveryFragment
            R.id.collectionFragment -> R.id.toCollectionFragment
            R.id.profileFragment -> R.id.toProfileFragment
            else -> null
        }
        selectedMenuId?.let { binding.bottomNavView.menu.findItem(it).isChecked = true }
    }
}
