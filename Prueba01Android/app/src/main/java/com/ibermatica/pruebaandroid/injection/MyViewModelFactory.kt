package com.ibermatica.pruebaandroid.injection

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ibermatica.pruebaandroid.ui.NewActivityFragmentViewModel


class MyViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewActivityFragmentViewModel(application) as T
    }
}