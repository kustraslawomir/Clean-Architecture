package slawomir.kustra.listing.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
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
    abstract fun bindCoinsListingViewmModel(viewModel: CoinsListingViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}