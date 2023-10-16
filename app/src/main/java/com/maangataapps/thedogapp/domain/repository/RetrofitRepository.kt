package com.maangataapps.thedogapp.domain.repository

import arrow.core.Either
import retrofit2.Call
import retrofit2.HttpException
import retrofit2.Response

interface RetrofitRepository: Repository {

    fun <T> executeSync(call: Call<T>): Either<Throwable, T> = executeSync(retrofit(call))

    fun <T> executeAsync(call: Call<T>, callback: (Either<Throwable, T>) -> Unit) {
        executeAsync(retrofit(call), callback)
    }

    private fun <T> retrofit(call: Call<T>): () -> T = { call.execute().run { handleResponse<T>() } }

    fun <T> Response<T>.handleResponse(): T {
        return if (isSuccessful) body()!! else throw HttpException(this)
    }

}