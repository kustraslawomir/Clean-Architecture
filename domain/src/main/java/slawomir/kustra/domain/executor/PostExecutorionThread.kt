package slawomir.kustra.domain.executor

import io.reactivex.schedulers.Schedulers

interface PostExecutorionThread {

        val scheduler: Schedulers
}