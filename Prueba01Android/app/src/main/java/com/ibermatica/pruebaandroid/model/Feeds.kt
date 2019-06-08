package com.ibermatica.pruebaandroid.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Feeds {

    /*@SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("feed")
    @Expose
    var feed: Feed? = null*/
    @SerializedName("items")
    @Expose
    var items: List<Item>? = null

}