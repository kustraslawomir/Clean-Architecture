package slawomir.kustra.data.datasource

import slawomir.kustra.data.repositories.DataSourceRepository
import javax.inject.Inject

open class DataSourceFactory  @Inject internal constructor(private val cacheRepositoryImpl: CacheRepositoryImpl, private val remoteRepositoryImpl: RemoteRepositoryImpl) {

    open fun getCoinsList(coinsCached: Boolean, cacheExpired: Boolean): DataSourceRepository {
        return if (coinsCached && !cacheExpired)
            cacheRepositoryImpl
        else remoteRepositoryImpl
    }

    open fun getCacheRepository() = cacheRepositoryImpl

}