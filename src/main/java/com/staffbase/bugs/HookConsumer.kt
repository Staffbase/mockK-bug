package com.staffbase.bugs

import com.staffbase.entities.EntityHook
import com.staffbase.entities.user.User

class HookConsumer {
    fun consumeHook(hook: EntityHook<User>) {
        hook(User())
    }
}