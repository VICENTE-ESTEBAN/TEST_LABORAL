package com.ibermatica.pruebaandroid.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Item {

    @SerializedName("title")
    @Expose
    var title: String? = null
   /* @SerializedName("pubDate")
    @Expose
    var pubDate: String? = null
    @SerializedName("link")
    @Expose
    var link: String? = null
    @SerializedName("guid")
    @Expose
    var guid: String? = null
    @SerializedName("author")
    @Expose
    var author: String? = null
    @SerializedName("thumbnail")
    @Expose
    var thumbnail: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("content")
    @Expose
    var content: String? = null
    @SerializedName("enclosure")
    @Expose
    var enclosure: Enclosure? = null*/
    @SerializedName("categories")
    @Expose
    var categories: List<String>? = null

}