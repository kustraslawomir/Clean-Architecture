package slawomir.kustra.ui.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import slawomir.kustra.ui.CoinApplication
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