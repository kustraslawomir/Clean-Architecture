package slawomir.kustra.ui

import android.app.Application
import slawomir.kustra.ui.injection.DaggerApplicationComponent
import timber.log.Timber

class CoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        DaggerApplicationComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }
}