package com.ibermatica.pruebaandroid.ui

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.ibermatica.pruebaandroid.R
import com.ibermatica.pruebaandroid.base.BaseViewModel
import com.ibermatica.pruebaandroid.model.Item
import com.ibermatica.pruebaandroid.network.FeedsApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class ItemsListViewModel: BaseViewModel(){

    @Inject
    lateinit var feedsApi: FeedsApi

    val feedListAdapter: ItemsListAdapter = ItemsListAdapter()
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    val errorMessage:MutableLiveData<Int> = MutableLiveData()

    private lateinit var subscription: Disposable

    init{
        loadItems()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    fun loadItems(){


        subscription = feedsApi.getFeeds()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrieveFeedsListStart() }
                .doOnTerminate { onRetrieveFeedsListFinish() }
                .subscribe(
                        { result -> onRetrieveFeedsListSuccess(result.items) },
                        { onRetrieveFeedsListError(it) }
                )
    }

    private fun onRetrieveFeedsListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveFeedsListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveFeedsListSuccess(postList:List<Item>?){
        feedListAdapter.updatePostList(postList)

    }

    private fun onRetrieveFeedsListError(ex:Throwable){
        feedListAdapter.updatePostList(null)

        errorMessage.value = R.string.items_error
    }
}