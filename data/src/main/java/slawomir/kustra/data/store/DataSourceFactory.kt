package slawomir.kustra.data.store

import slawomir.kustra.data.repository.DataSource

open class DataSourceFactory constructor(private val cacheRepositoryImpl: CacheRepositoryImpl, private val remoteRepositoryImpl: RemoteRepositoryImpl) {

    open fun getCoinsList(coinsCached: Boolean, cacheExpired: Boolean): DataSource {
        return if (coinsCached && !cacheExpired)
            cacheRepositoryImpl
        else remoteRepositoryImpl
    }

    open fun getCacheRepository() = cacheRepositoryImpl
}