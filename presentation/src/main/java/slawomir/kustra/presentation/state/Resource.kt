package slawomir.kustra.presentation.state

class Resource<out T>(val state: DataState,
                      val data : T?,
                      val message : String?)