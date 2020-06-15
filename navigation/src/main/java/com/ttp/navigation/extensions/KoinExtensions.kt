package com.ttp.navigation.extensions

import androidx.annotation.NavigationRes
import androidx.navigation.NavGraph
import androidx.navigation.NavInflater
import org.koin.core.definition.BeanDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.bind

fun Module.navGraph(@NavigationRes graphResId: Int): BeanDefinition<NavGraph> =
    factory(named(graphResId.toString())) {
        val inflater: NavInflater = get()
        inflater.inflate(graphResId)
    } bind NavGraph::class