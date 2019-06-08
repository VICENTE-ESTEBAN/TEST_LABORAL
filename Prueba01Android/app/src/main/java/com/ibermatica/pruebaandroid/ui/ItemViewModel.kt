package com.ibermatica.pruebaandroid.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ibermatica.pruebaandroid.model.Item


class ItemViewModel: ViewModel() {
    private val itemTitle = MutableLiveData<String>()

    fun bind(item: Item){
        itemTitle.value = item.title
    }

    fun getItemTitle():MutableLiveData<String>{
        return itemTitle
    }

    fun setItemTitle(title:String){
        itemTitle.value = title
    }
}