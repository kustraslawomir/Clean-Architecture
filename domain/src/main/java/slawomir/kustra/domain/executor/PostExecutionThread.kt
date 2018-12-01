package slawomir.kustra.domain.executor

import io.reactivex.Scheduler

interface PostExecutionThread {

        val scheduler: Scheduler
}