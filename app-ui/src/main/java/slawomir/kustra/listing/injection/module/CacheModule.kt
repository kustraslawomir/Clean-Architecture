package slawomir.kustra.listing.injection.module

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import slawomir.kustra.cache.CacheRepositoryImpl
import slawomir.kustra.cache.database.CacheDatabase

@Module
abstract class CacheModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun providesDataBase(application: Application) : CacheDatabase = CacheDatabase.getDatabase(application)
    }

    @Binds
    abstract fun bindProjectsCache(cacheRepositoryImpl: CacheRepositoryImpl) : CacheRepositoryImpl
}