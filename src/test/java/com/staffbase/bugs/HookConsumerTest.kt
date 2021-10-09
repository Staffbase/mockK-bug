package com.staffbase.bugs

import com.staffbase.entities.EntityHook
import com.staffbase.entities.user.User
import io.mockk.justRun
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class HookConsumerTest {

    @Test
    fun `the hook consumer works`() {
        var testBool = false
        val hook = EntityHook { _: User ->
            testBool = true
        }

        assertFalse(testBool)

        HookConsumer().consumeHook(hook)

        assertTrue(testBool)
    }

    @Test
    fun `mocking a SAM converted object will fail`() {
        val hookConsumer = mockk<HookConsumer>()
        justRun { hookConsumer.consumeHook(any()) }
    }
}