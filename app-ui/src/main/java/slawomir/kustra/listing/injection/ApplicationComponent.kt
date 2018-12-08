package slawomir.kustra.listing.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import slawomir.kustra.listing.CoinApplication
import slawomir.kustra.listing.injection.module.*
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ApplicationModule::class,
    UiModule::class,
    PresentationModule::class,
    DataModule::class,
    CacheModule::class,
    RemoteModule::class])

interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(applicationComponent: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: CoinApplication)
}