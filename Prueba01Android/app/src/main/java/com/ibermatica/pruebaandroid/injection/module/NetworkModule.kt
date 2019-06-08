package com.ibermatica.pruebaandroid.injection.module

import com.ibermatica.pruebaandroid.network.FeedsApi
import com.ibermatica.pruebaandroid.network.util.BASE_URL
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

    @Provides
    @Singleton
    internal fun provideFeedsApi(retrofit: Retrofit): FeedsApi {
        return retrofit.create(FeedsApi::class.java)
    }


    @Provides
    @Singleton
    fun provideRetrofitInterface(): Retrofit {

        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }
}