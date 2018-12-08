package slawomir.kustra.listing.injection.module

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import slawomir.kustra.domain.executor.PostExecutionThread
import slawomir.kustra.listing.CoinsListingActivity
import slawomir.kustra.listing.scheduler.AndroidUiThread

@Module
abstract class UiModule {

    @Binds
    abstract fun bindPostExectutionThread(androidUiThread: AndroidUiThread): PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributeCoinsListingActivity(): CoinsListingActivity
}