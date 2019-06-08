package com.ibermatica.pruebaandroid.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Feed {

    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("link")
    @Expose
    var link: String? = null
    @SerializedName("author")
    @Expose
    var author: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("image")
    @Expose
    var image: String? = null

}