package slawomir.kustra.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.observers.DisposableObserver
import slawomir.kustra.domain.intercator.storage.GetObservedCoinsUseCase
import slawomir.kustra.domain.model.listing.Coin
import slawomir.kustra.presentation.mapper.ViewCoinMapper
import slawomir.kustra.presentation.model.PresentationCoin
import slawomir.kustra.presentation.state.DataState
import slawomir.kustra.presentation.state.Resource

class BrowseObservedCoinsViewModel(private val getObservedCoinsUseCase: GetObservedCoinsUseCase,
                                   private val viewCoinMapper: ViewCoinMapper<Coin, PresentationCoin>) : ViewModel() {

    private val coinData: MutableLiveData<Resource<List<PresentationCoin>>> = MutableLiveData()

    private fun getCoins() = coinData

    override fun onCleared() {
        getObservedCoinsUseCase.dispose()
        super.onCleared()
    }

    fun fetchCoins() {
        coinData.postValue(Resource(DataState.LOADING, null, null))
        return getObservedCoinsUseCase.fetch(ObservedCoinsObservable())
    }

    inner class ObservedCoinsObservable : DisposableObserver<List<Coin>>() {
        override fun onNext(value: List<Coin>) {
            coinData.postValue(Resource(DataState.SUCCESS, value.map {
                viewCoinMapper.mapToViewCoin(it)
            }, null))
        }

        override fun onComplete() {

        }

        override fun onError(e: Throwable) {
            coinData.postValue(Resource(DataState.ERROR, null, e.message))
        }
    }
}