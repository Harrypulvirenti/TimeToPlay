package com.ttp.feature.launch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.ttp.navigation.extensions.setupMainGraph

internal class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val navHostFragment: NavHostFragment
        get() = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupMainGraph(
            navHostFragment.navController,
            R.navigation.main_nav_graph
        )
    }
}
