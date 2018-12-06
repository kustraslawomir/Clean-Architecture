package slawomir.kustra.remote.service

import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET("listings/latest")
    fun getCryptoListing(@Header("X-CMC_PRO_API_KEY") apiKey: String)
}