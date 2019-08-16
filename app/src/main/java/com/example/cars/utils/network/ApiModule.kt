package com.example.cars.utils.network

import com.example.cars.BuildConfig
import retrofit2.Retrofit
import javax.inject.Singleton
import dagger.Provides
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

@Module
class ApiModule {
    @Provides
    @Singleton
    internal fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    internal fun provideOkhttpClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    @Provides
    @Singleton
    internal fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BuildConfig.CARS_API)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    internal fun provideMovieApiService(retrofit: Retrofit): CarsApi = retrofit
        .create<CarsApi>(CarsApi::class.java)
}