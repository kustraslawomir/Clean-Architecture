package slawomir.kustra.presentation.state

sealed class DataState {

    object LOADING : DataState()
    object SUCCESS : DataState()
    object ERROR : DataState()
}