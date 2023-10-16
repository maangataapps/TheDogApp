package com.maangataapps.thedogapp.infrastructure.utils

import com.maangataapps.thedogapp.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

fun getBodyHttpLoggingInterceptor(): Interceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

fun getOkHttpClientBuilder(): OkHttpClient.Builder {
    return OkHttpClient.Builder()
        .addInterceptor(getBodyHttpLoggingInterceptor())
        .addInterceptor(getHttpAuthorizationInterceptor())
        .readTimeout(45, TimeUnit.SECONDS)
        .callTimeout(45, TimeUnit.SECONDS)
        .connectTimeout(45, TimeUnit.SECONDS)
        .writeTimeout(45, TimeUnit.SECONDS)
}

fun getRetrofitBuilder(): Retrofit.Builder {
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    return Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BuildConfig.BASE_URL)
        .client(getOkHttpClientBuilder().build())
}

private fun getHttpAuthorizationInterceptor(): Interceptor {
    return Interceptor { chain ->
        val request = chain
            .request().newBuilder()
            .addHeader(X_API_KEY, BuildConfig.DOG_API_KEY)
            .build()
        chain.proceed(request)
    }
}