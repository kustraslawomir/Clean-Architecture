package slawomir.kustra.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.observers.DisposableObserver
import slawomir.kustra.data.model.listing.Coin
import slawomir.kustra.data.usecase.local.GetObservedCoinsUseCase
import slawomir.kustra.presentation.mapper.ViewCoinMapper
import slawomir.kustra.presentation.model.UiCoin
import slawomir.kustra.presentation.state.Resource
import slawomir.kustra.presentation.state.ResponseState

class BrowseObservedCoinsViewModel(private val getObservedCoinsUseCase: GetObservedCoinsUseCase,
                                   private val viewCoinMapper: ViewCoinMapper<Coin, UiCoin>) : ViewModel() {

    private val coinData: MutableLiveData<Resource<List<UiCoin>>> = MutableLiveData()

    private fun getCoins() = coinData

    override fun onCleared() {
        getObservedCoinsUseCase.dispose()
        super.onCleared()
    }

    fun fetchCoins() {
        coinData.postValue(Resource(ResponseState.LOADING, null, null))
        return getObservedCoinsUseCase.fetch(ObservedCoinsObservable())
    }

    inner class ObservedCoinsObservable : DisposableObserver<List<Coin>>() {
        override fun onNext(value: List<Coin>) {
            coinData.postValue(Resource(ResponseState.SUCCESS, value.map {
                viewCoinMapper.mapToViewCoin(it)
            }, null))
        }

        override fun onComplete() {

        }

        override fun onError(e: Throwable) {
            coinData.postValue(Resource(ResponseState.ERROR, null, e.message))
        }
    }
}