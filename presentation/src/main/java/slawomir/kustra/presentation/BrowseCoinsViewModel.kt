package slawomir.kustra.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableObserver
import slawomir.kustra.domain.intercator.network.GetCryptoListingUserCase
import slawomir.kustra.domain.intercator.storage.ObserveCurrencyUseCase
import slawomir.kustra.domain.intercator.storage.StopObservingCurrencyUseCase
import slawomir.kustra.domain.model.listing.Coin
import slawomir.kustra.presentation.mapper.ViewCoinMapper
import slawomir.kustra.presentation.model.CoinPresentation
import slawomir.kustra.presentation.state.DataState
import slawomir.kustra.presentation.state.Resource

class BrowseCoinsViewModel(private val getCryptoListingUserCase: GetCryptoListingUserCase,
                           private val observeCurrencyUseCase: ObserveCurrencyUseCase,
                           private val stopObservingCurrencyUseCase: StopObservingCurrencyUseCase,
                           private val viewCoinMapper: ViewCoinMapper<Coin, CoinPresentation>) : ViewModel() {

    private val coinsData: MutableLiveData<Resource<List<CoinPresentation>>> = MutableLiveData()

    override fun onCleared() {
        getCryptoListingUserCase.dispose()
        super.onCleared()
    }

    fun getCoins(): MutableLiveData<Resource<List<CoinPresentation>>> = coinsData

    fun fetchCoins() {
        coinsData.postValue(Resource(DataState.LOADING, null, null))
        return getCryptoListingUserCase.fetch(CoinsSubscriber())
    }

    fun observeCoin(id: Int) {
        coinsData.postValue(Resource(DataState.LOADING, null, null))
        return observeCurrencyUseCase.post(ObserveCoinsSubscriber(), ObserveCurrencyUseCase.Params(id))
    }

    fun stopObservingCoin(id: Int) {
        coinsData.postValue(Resource(DataState.LOADING, null, null))
        return stopObservingCurrencyUseCase.post(StopObserveCoinsSubscriber(), StopObservingCurrencyUseCase.Params(id))
    }


    inner class CoinsSubscriber : DisposableObserver<List<Coin>>() {
        override fun onNext(value: List<Coin>) {
            coinsData.postValue(Resource(DataState.SUCCESS,
                    value.map {
                        viewCoinMapper.mapToViewCoin(it)
                    }, null))
        }

        override fun onComplete() {}

        override fun onError(e: Throwable) {
            coinsData.postValue(Resource(DataState.ERROR, null, e.message))

        }
    }

    inner class ObserveCoinsSubscriber : DisposableCompletableObserver() {
        override fun onComplete() {
            coinsData.postValue(Resource(DataState.SUCCESS, null, null))
        }

        override fun onError(e: Throwable) {
            coinsData.postValue(Resource(DataState.ERROR, null, e.message))
        }
    }

    inner class StopObserveCoinsSubscriber : DisposableCompletableObserver() {
        override fun onComplete() {
            coinsData.postValue(Resource(DataState.SUCCESS, null, null))
        }

        override fun onError(e: Throwable) {
            coinsData.postValue(Resource(DataState.ERROR, null, e.message))
        }
    }


}