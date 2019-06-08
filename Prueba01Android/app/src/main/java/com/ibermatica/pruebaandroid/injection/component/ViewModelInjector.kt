package com.ibermatica.pruebaandroid.injection.component

import com.ibermatica.pruebaandroid.injection.module.NetworkModule
import com.ibermatica.pruebaandroid.ui.ItemsListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ViewModelInjector {

    fun inject(postListViewModel: ItemsListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}