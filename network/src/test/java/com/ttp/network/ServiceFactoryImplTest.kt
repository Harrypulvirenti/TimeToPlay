package com.ttp.network

import com.ttp.shared.interfaces.ApplicationBundle
import io.kotest.matchers.types.shouldBeInstanceOf
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

internal class ServiceFactoryImplTest {

    private val applicationBundle: ApplicationBundle = mockk {
        every { isDebug } returns true
    }

    private val sut = ServiceFactoryImpl("https://www.mockservice.com/", emptyList())

    @Test
    fun `Should create a TestService instance`() {

        sut.create(TestService::class).shouldBeInstanceOf<TestService>()
    }
}