package com.staffbase.entities

@FunctionalInterface
fun interface EntityHook<T : Entity>: (T) -> Unit