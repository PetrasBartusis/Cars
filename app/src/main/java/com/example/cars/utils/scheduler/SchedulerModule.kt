package com.example.cars.utils.scheduler

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

@Module
class SchedulerModule {
    @Provides
    @Named("main")
    fun provideMainScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    @Named("io")
    fun providesIOScheduler(): Scheduler = Schedulers.io()
}