package com.ttp.feature.home

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.ttp.core.base.BaseFragment
import com.ttp.extensions.android.observe
import com.ttp.extensions.kotlin.lazyFast
import com.ttp.feature.home.adapter.GameAdapter
import com.ttp.feature.home.di.homeModules
import com.ttp.feature.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.module.Module

internal class HomeFragment : BaseFragment(R.layout.fragment_home) {

    internal val viewModel: HomeViewModel by viewModel()

    private val gameAdapter by lazyFast { GameAdapter(requireContext(), viewModel.playerController) }

    private val pageChangeListener = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            viewModel.onGamePageSelected(position)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        observeDataFlow()

        viewModel.getGames()
    }

    private fun observeDataFlow() {
        observe(viewModel.state) {
            gameAdapter.submitList(it)
        }
    }

    private fun setupUI() {
        with(gameViewPager) {
            adapter = gameAdapter
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3

            setPageTransformer(MarginPageTransformer(resources.getDimensionPixelSize(R.dimen.carousel_page_margin)))
            registerOnPageChangeCallback(pageChangeListener)
        }
    }

    override fun onDestroyView() {
        gameViewPager.unregisterOnPageChangeCallback(pageChangeListener)
        super.onDestroyView()
    }

    override fun getKoinModules(): List<Module> = homeModules
}