package com.ttp.feature.home

import com.ttp.core.base.BaseFragment
import com.ttp.feature.home.di.homeModules
import com.ttp.feature.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.module.Module

internal class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModel()

    override fun getKoinModules(): List<Module> = homeModules
}