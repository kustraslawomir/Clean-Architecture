package slawomir.kustra.ui.scheduler

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import slawomir.kustra.domain.executor.PostExecutionThread

class AndroidUiThread : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}