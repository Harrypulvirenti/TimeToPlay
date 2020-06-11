package com.ttp.network.calladapter

import arrow.core.Either
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

internal class CoroutinesCallAdapterFactory : CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {

        if (!returnType.isTypeSupported()) return null

        val containerType = returnType.getParameterUpperBoundUnsafe(0)

        return when (getRawType(returnType)) {
            Call::class.java -> {
                CoroutinesCallAdapter<Any>(containerType.getBodyType())
            }
            else -> null
        }
    }

    /**
     * This function check if the returnType is a supported return type for the CallAdapter.
     * It first check if the Type is a ParameterizedType trying to cast it then it extract the raw type.
     * Also it extract the error type
     * If the raw types are equals to the supported types it return true otherwise false.
     * */
    private fun Type.isTypeSupported(): Boolean {
        val parameterizedType = this as? ParameterizedType
        val rawType = parameterizedType?.let { getRawType(getParameterUpperBound(0, it)) }
        val isEither = rawType == Either::class.java

        val errorType = parameterizedType
            ?.getParameterUpperBound(0)
            ?.getParameterUpperBound(0)
            ?.let { getRawType(it) }

        val isErrorThrowable = errorType == Throwable::class.java

        return isEither && isErrorThrowable
    }

    /**
     * This is an util extension that basically allow the user to extract the ParameterUpperBound
     * without casting the original Type. The cast is performed inside the function in an unsafe modality.
     * This means that a potential user should always check the type compatibility before use this unsafe
     * utility.
     * */
    private fun Type.getParameterUpperBoundUnsafe(index: Int): Type =
        getParameterUpperBound(index, this as ParameterizedType)

    private fun Type.getParameterUpperBound(index: Int): Type? =
        (this as? ParameterizedType)?.let {
            getParameterUpperBound(index, it)
        }

    private fun Type.getBodyType(): Type = getParameterUpperBoundUnsafe(1)
}