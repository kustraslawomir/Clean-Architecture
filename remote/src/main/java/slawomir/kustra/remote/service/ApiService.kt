package slawomir.kustra.remote.service

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import slawomir.kustra.remote.model.CryptoListingsResponse

interface ApiService {

    @GET("listings/latest")
    fun getCryptoListing(@Header("X-CMC_PRO_API_KEY") apiKey: String) : Observable<CryptoListingsResponse>
}