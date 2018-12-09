package slawomir.kustra.data.executor

import io.reactivex.Scheduler

interface PostExecutionThread {

        val scheduler: Scheduler
}