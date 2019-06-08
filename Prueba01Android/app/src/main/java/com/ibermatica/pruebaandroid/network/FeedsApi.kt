package com.ibermatica.pruebaandroid.network

import com.ibermatica.pruebaandroid.model.Feeds
import io.reactivex.Observable
import retrofit2.http.GET


/**
 * The interface which provides methods to get result of webservices
 */
interface FeedsApi {

    @GET("api.json?rss_url=http%3A%2F%2Fep00.epimg.net%2Frss%2Ftags%2Fultimas_noticias.xml&api_key=cholcaalacwrsnfb7prpt38b92oqdhq4udcvswpo")
    fun getFeeds(): Observable<Feeds>
}