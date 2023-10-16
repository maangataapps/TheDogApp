@file:OptIn(DelicateCoroutinesApi::class)

package com.maangataapps.thedogapp.domain.interactor

import arrow.core.Either
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

interface Interactor<T> {
    fun execute(block: () -> Either<Throwable, T>): Deferred<Either<Throwable, T>> = GlobalScope.async { block() }
}