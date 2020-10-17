package com.ttp.navigation.extensions

import androidx.annotation.NavigationRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.ttp.navigation.MainNavigation
import org.koin.android.ext.android.getKoin
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun AppCompatActivity.setupMainGraph(
    navController: NavController,
    @NavigationRes mainGraphId: Int
) {
    loadInflaterModule(navController)

    navController.setupContributors(
        mainGraphId,
        getKoin().getGraphContributors<MainNavigation>()
    )
}

private fun loadInflaterModule(navController: NavController) =
    loadKoinModules(module {
        single(override = true) { navController.navInflater }
    })
