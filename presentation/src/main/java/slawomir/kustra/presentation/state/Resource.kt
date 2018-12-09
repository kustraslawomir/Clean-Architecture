package slawomir.kustra.presentation.state

class Resource<out T>(val state: ResponseState,
                      val data : T?,
                      val message : String?)