package com.ibermatica.pruebaandroid.base

import android.arch.lifecycle.ViewModel
import com.ibermatica.pruebaandroid.injection.component.DaggerViewModelInjector

import com.ibermatica.pruebaandroid.injection.component.ViewModelInjector
import com.ibermatica.pruebaandroid.injection.module.NetworkModule
import com.ibermatica.pruebaandroid.ui.ItemsListViewModel

abstract class BaseViewModel:ViewModel(){

    private val injector: ViewModelInjector  =  DaggerViewModelInjector.builder().networkModule(NetworkModule).build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is ItemsListViewModel -> injector.inject(this)
        }

    }
}