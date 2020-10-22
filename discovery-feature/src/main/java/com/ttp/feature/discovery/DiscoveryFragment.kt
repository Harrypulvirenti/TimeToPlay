package com.ttp.feature.discovery

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.ttp.core.base.BaseFragment
import com.ttp.core.extensions.viewBinding
import com.ttp.extensions.android.observe
import com.ttp.extensions.kotlin.lazyFast
import com.ttp.feature.discovery.adapter.GameAdapter
import com.ttp.feature.discovery.databinding.FragmentDiscoveryBinding
import com.ttp.feature.discovery.di.discoveryModules
import com.ttp.feature.discovery.viewmodel.DiscoveryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.module.Module

internal class DiscoveryFragment : BaseFragment(R.layout.fragment_discovery) {

    private val binding by viewBinding(FragmentDiscoveryBinding::bind)

    internal val viewModel: DiscoveryViewModel by viewModel()

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
        with(binding.gameViewPager) {
            adapter = gameAdapter
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3

            setPageTransformer(MarginPageTransformer(resources.getDimensionPixelSize(R.dimen.carousel_page_margin)))
        }
    }

    override fun onResume() {
        super.onResume()
        binding.gameViewPager.registerOnPageChangeCallback(pageChangeListener)
    }

    override fun onStop() {
        binding.gameViewPager.unregisterOnPageChangeCallback(pageChangeListener)
        super.onStop()
    }

    override fun getKoinModules(): List<Module> = discoveryModules
}
