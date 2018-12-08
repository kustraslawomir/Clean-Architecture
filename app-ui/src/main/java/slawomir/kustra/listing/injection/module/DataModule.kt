package slawomir.kustra.listing.injection.module

import dagger.Binds
import dagger.Module
import slawomir.kustra.data.DataRepository
import slawomir.kustra.domain.repository.DomainRepository


@Module
abstract class DataModule {
    @Binds
    abstract fun bindDomainRepository(domainRepository: DataRepository) : DomainRepository
}