package slawomir.kustra.listing.injection.module

import dagger.Binds
import dagger.Module
import slawomir.kustra.data.ApplicationDataSourceImpl
import slawomir.kustra.data.ApplicationDataSource


@Module
abstract class DataModule {
    @Binds
    abstract fun bindDomainRepository(domainRepository: ApplicationDataSourceImpl) : ApplicationDataSource
}