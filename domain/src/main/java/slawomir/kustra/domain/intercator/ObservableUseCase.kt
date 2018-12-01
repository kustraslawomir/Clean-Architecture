package slawomir.kustra.domain.intercator

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import slawomir.kustra.domain.executor.PostExecutionThread

abstract class ObservableUseCase<T, in Params> constructor(private val postExecutionThread: PostExecutionThread) {

    private val compositeDisposable = CompositeDisposable()

    protected abstract fun getObservableUseCase(params: Params? = null) : Observable<T>

    open fun run(observer : DisposableObserver<T>, params: Params?=null){
        compositeDisposable.add(getObservableUseCase(params)
                .subscribeOn(Schedulers.io())
                .observeOn(postExecutionThread.scheduler)
                .subscribeWith(observer))
    }

    fun dispose(){
        compositeDisposable.dispose()
    }
}