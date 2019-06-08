package com.ibermatica.pruebaandroid.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Enclosure {

    @SerializedName("link")
    @Expose
    var link: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("length")
    @Expose
    var length: Int? = null

}