package slawomir.kustra.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import io.reactivex.Flowable
import slawomir.kustra.cache.Constants.COINS_TABLE
import slawomir.kustra.cache.Constants.COIN_ID
import slawomir.kustra.cache.Constants.IS_OBSERVED_COLUMN
import slawomir.kustra.cache.model.CacheCoin

@Dao
abstract class CoinsDao {

    @Query("SELECT * FROM $COINS_TABLE")
    abstract fun getCachedCoins(): Flowable<List<CacheCoin>>

    @Query("SELECT * FROM $COINS_TABLE")
    abstract fun getCachedCoinsAsList(): List<CacheCoin>

    @Insert(onConflict = REPLACE)
    abstract fun insertCoins(coins: List<CacheCoin>)

    @Query("DELETE FROM $COINS_TABLE")
    abstract fun clearCache()

    @Query("SELECT * FROM $COINS_TABLE WHERE $IS_OBSERVED_COLUMN = 1")
    abstract fun getObservedCoins(): Flowable<List<CacheCoin>>

    @Query("UPDATE $COINS_TABLE SET $IS_OBSERVED_COLUMN = :isObserved WHERE $COIN_ID = :coinId")
    abstract fun changeObserveCoinState(isObserved: Boolean, coinId: Int)

}