package slawomir.kustra.presentation.state

class Resource<out T>(private val state: DataState,
                      private val data : T?,
                      private val message : String?)