package slawomir.kustra.listing.injection.module

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import slawomir.kustra.listing.injection.factory.ViewModelFactory
import slawomir.kustra.listing.injection.key.ViewModelKey
import slawomir.kustra.presentation.CoinsListingViewModel

@Module
abstract class PresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(CoinsListingViewModel::class)
    abstract fun bindCoinsListingViewmModel(viewModel: CoinsListingViewModel): CoinsListingViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelFactory
}