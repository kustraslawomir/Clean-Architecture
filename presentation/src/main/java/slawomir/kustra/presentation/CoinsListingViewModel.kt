package slawomir.kustra.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableObserver
import slawomir.kustra.data.model.listing.Coin
import slawomir.kustra.data.usecase.local.ObserveCurrencyUseCase
import slawomir.kustra.data.usecase.local.StopObservingCurrencyUseCase
import slawomir.kustra.data.usecase.remote.GetCryptoListingUseCase
import slawomir.kustra.presentation.mapper.ViewMapper
import slawomir.kustra.presentation.model.UiCoin
import slawomir.kustra.presentation.state.Resource
import slawomir.kustra.presentation.state.ResponseState
import javax.inject.Inject

class CoinsListingViewModel @Inject internal constructor(private val getCryptoListingUserCase: GetCryptoListingUseCase,
                                                         private val observeCurrencyUseCase: ObserveCurrencyUseCase,
                                                         private val stopObservingCurrencyUseCase: StopObservingCurrencyUseCase,
                                                         private val viewCoinMapper: ViewMapper) : ViewModel() {

    private val uiCoins: MutableLiveData<Resource<List<UiCoin>>> = MutableLiveData()

    override fun onCleared() {
        getCryptoListingUserCase.dispose()
        super.onCleared()
    }

    fun getCoins(): MutableLiveData<Resource<List<UiCoin>>> = uiCoins

    fun fetchCoins() {
        uiCoins.postValue(Resource(ResponseState.LOADING, null, null))
        return getCryptoListingUserCase.fetch(CoinsSubscriber())
    }

    fun observeCoin(id: Int) {
        uiCoins.postValue(Resource(ResponseState.LOADING, null, null))
        return observeCurrencyUseCase.post(ObserveCoinsSubscriber(), ObserveCurrencyUseCase.Params(id))
    }

    fun stopObservingCoin(id: Int) {
        uiCoins.postValue(Resource(ResponseState.LOADING, null, null))
        return stopObservingCurrencyUseCase.post(StopObserveCoinsSubscriber(), StopObservingCurrencyUseCase.Params(id))
    }

    inner class CoinsSubscriber : DisposableObserver<List<Coin>>() {
        override fun onNext(value: List<Coin>) {
            uiCoins.postValue(Resource(ResponseState.SUCCESS,
                    value.map {
                        viewCoinMapper.mapToViewCoin(it)
                    }, null))
        }

        override fun onComplete() {

        }

        override fun onError(e: Throwable) {
            uiCoins.postValue(Resource(ResponseState.ERROR, null, e.message))
        }
    }

    inner class ObserveCoinsSubscriber : DisposableCompletableObserver() {
        override fun onComplete() {
            uiCoins.postValue(Resource(ResponseState.SUCCESS, null, null))
        }

        override fun onError(e: Throwable) {
            uiCoins.postValue(Resource(ResponseState.ERROR, null, e.message))
        }
    }

    inner class StopObserveCoinsSubscriber : DisposableCompletableObserver() {
        override fun onComplete() {
            uiCoins.postValue(Resource(ResponseState.SUCCESS, null, null))
        }

        override fun onError(e: Throwable) {
            uiCoins.postValue(Resource(ResponseState.ERROR, null, e.message))
        }
    }


}