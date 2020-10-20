package com.ttp.datasources.di

import com.ttp.datasources.game.GameDataSource
import com.ttp.datasources.game.GameDataSourceImpl
import com.ttp.network.ServiceFactory
import com.ttp.network.create
import com.ttp.network.di.networkModule
import org.koin.dsl.module

private val gameModule = module {

    single<GameDataSource> {
        val serviceFactory = get<ServiceFactory>()
        GameDataSourceImpl(
            serviceFactory.create(),
            get()
        )
    }
}

val gameRepositoryModules = gameModule + networkModule
