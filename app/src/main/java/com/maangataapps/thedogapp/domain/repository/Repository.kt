package com.maangataapps.thedogapp.domain.repository

import arrow.core.Either
import arrow.effects.IO

interface Repository {

    fun <T> executeSync(call: () -> T): Either<Throwable, T> = IO { call() }.attempt().unsafeRunSync()

    fun <T> executeAsync(call: () -> T, callback: (Either<Throwable, T>) -> Unit) {
        IO { call() }.unsafeRunAsync(callback)
    }

    fun <T> execute(action: () -> T): Either<Throwable, T> {
        return IO { action() }.attempt().unsafeRunSync()
    }
}