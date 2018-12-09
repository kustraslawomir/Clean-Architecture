
import io.reactivex.Observable

interface DomainRepository {

    fun getCoins(): Observable<List<Coin>>

    fun observeCoin(id: Int) : io.reactivex.Completable

    fun stopObservingCoin(id: Int) : io.reactivex.Completable

    fun getObservedCoins() : io.reactivex.Observable<List<Coin>>
}