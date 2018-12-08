package slawomir.kustra.listing.injection.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import slawomir.kustra.data.repository.RemoteRepository
import slawomir.kustra.remote.service.ApiService
import slawomir.kustra.remote.service.ApiServiceFactory
import slawomir.kustra.remote.service.RemoteRepositoryImpl

@Module
abstract class RemoteModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideRepository(): ApiService = ApiServiceFactory.makeApiService()
    }

    @Binds
    abstract fun bindRemote(remoteRepositoryImpl: RemoteRepositoryImpl) : RemoteRepository
}