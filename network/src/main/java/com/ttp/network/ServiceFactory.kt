package com.ttp.network

import kotlin.reflect.KClass

interface ServiceFactory {

    fun <R : Any> create(klass: KClass<R>): R
}