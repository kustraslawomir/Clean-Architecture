package slawomir.kustra.remote.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

object ApiServiceFactory {

    fun makeApiService(): ApiService {
        val okHttpClient = getOkHttpClient(getHttpLoggingInterceptor())
        return getRetrofitService(okHttpClient)
    }

    private fun getRetrofitService(okHttpClient: OkHttpClient): ApiService {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://pro-api.coinmarketcap.com/v1/cryptocurrency/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit.create(ApiService::class.java)
    }


    private fun getOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) =
            OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .build()

    private fun getHttpLoggingInterceptor() =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

}