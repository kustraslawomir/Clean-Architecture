package slawomir.kustra.listing.scheduler

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import slawomir.kustra.domain.executor.PostExecutionThread
import javax.inject.Inject

class AndroidUiThread  @Inject internal constructor(): PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}