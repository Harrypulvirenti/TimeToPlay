package com.ttp.navigation.extensions

import androidx.annotation.NavigationRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import org.koin.android.ext.android.getKoin
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun AppCompatActivity.setupNavigation(
    navController: NavController,
    @NavigationRes mainGraphId: Int
) {
    loadInflaterModule(navController)

    val mainGraph = navController.navInflater.inflate(mainGraphId)

    injectSubGraphs(mainGraph)

    navController.graph = mainGraph
}

private fun loadInflaterModule(navController: NavController) =
    loadKoinModules(module {
        single { navController.navInflater }
    })

private fun AppCompatActivity.injectSubGraphs(mainGraph: NavGraph) =
    getKoin().getAll<NavGraph>().forEach(mainGraph::addAll)