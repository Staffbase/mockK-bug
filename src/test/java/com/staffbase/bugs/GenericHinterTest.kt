package com.staffbase.bugs

import com.staffbase.entities.Provider
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

typealias StringProviderType = Provider<String>

class GenericHinterTest {

    @Test
    fun `auto hints do not work`() {

        val expected = "Hello, World!"
        val mockedProvider = mockk<Provider<String>>()

        every {
            mockedProvider.get()
        } returns expected

        Assertions.assertEquals(expected, mockedProvider.get())
    }

    @Test
    fun `Typealias fails as well`() {
        val expected = "Hello, World!"

        val mockedProvider = mockk<StringProviderType>()

        every {
            mockedProvider.get()
        } returns expected

        Assertions.assertEquals(expected, mockedProvider.get())
    }

    @Test
    fun `manually setting the hints works`() {

        val expected = "Hello, World!"
        val mockedProvider = mockk<Provider<String>>()

        every {
            mockedProvider.hint(String::class).get()
        } returns expected

        Assertions.assertEquals(expected, mockedProvider.get())

        every {
            hint(String::class)
            mockedProvider.get()
        } returns expected

        Assertions.assertEquals(expected, mockedProvider.get())
    }

    @Test
    fun `class typing the provider works as well`() {

        val expected = "Hello, World!"

        class StringProvider : Provider<String> {
            override fun get() = "something"
        }

        val mockedProvider = mockk<StringProvider>()

        every {
            mockedProvider.get()
        } returns expected

        Assertions.assertEquals(expected, mockedProvider.get())
    }
}