package com.ttp.navigation.extensions

import androidx.annotation.NavigationRes
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavOptions

fun NavController.setupContributors(
    @NavigationRes graphId: Int,
    contributors: List<NavGraph>
) {
    val inflatedGraph = navInflater.inflate(graphId)
    contributors.forEach(inflatedGraph::addAll)
    graph = inflatedGraph
}

fun withNavOptions(configuration: NavOptions.Builder.() -> Unit): NavOptions =
    NavOptions.Builder().apply(configuration).build()
