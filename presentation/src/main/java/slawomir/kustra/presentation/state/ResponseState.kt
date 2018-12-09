package slawomir.kustra.presentation.state

sealed class ResponseState {

    object LOADING : ResponseState()
    object SUCCESS : ResponseState()
    object ERROR : ResponseState()
}