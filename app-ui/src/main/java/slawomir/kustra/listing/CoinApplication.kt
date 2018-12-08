package slawomir.kustra.listing

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import slawomir.kustra.listing.injection.DaggerApplicationComponent
import timber.log.Timber
import javax.inject.Inject

class CoinApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = injector

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }
}