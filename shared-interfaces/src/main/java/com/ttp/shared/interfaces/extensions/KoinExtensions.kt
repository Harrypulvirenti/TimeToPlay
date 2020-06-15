package com.ttp.shared.interfaces.extensions

import com.ttp.shared.interfaces.ApplicationInitializer
import org.koin.core.definition.Definition
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.bind

fun Module.appInitializer(definition: Definition<ApplicationInitializer>) =
    factory(
        named(definition.toString()),
        definition = definition
    ) bind ApplicationInitializer::class