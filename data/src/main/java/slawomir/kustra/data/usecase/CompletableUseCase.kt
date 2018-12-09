package slawomir.kustra.data.usecase

import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers
import slawomir.kustra.data.executor.PostExecutionThread

abstract class CompletableUseCase<in Params> constructor(private val postExecutionThread: PostExecutionThread) {

    private val compositeDisposable = CompositeDisposable()

    protected abstract fun getCompletableUseCase(params: Params? = null) : Completable

    open fun post(observer : DisposableCompletableObserver, params: Params?=null){
        compositeDisposable.add(getCompletableUseCase(params)
                .subscribeOn(Schedulers.io())
                .observeOn(postExecutionThread.scheduler)
                .subscribeWith(observer))
    }

    fun dispose(){
        compositeDisposable.dispose()
    }
}