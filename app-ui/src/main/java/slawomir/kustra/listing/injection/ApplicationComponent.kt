package slawomir.kustra.listing.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import slawomir.kustra.listing.CoinApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(applicationComponent: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: CoinApplication)
}