package slawomir.kustra.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import slawomir.kustra.cache.Constants.COINS_TABLE
import slawomir.kustra.cache.Constants.COIN_ID
import slawomir.kustra.cache.Constants.IS_OBSERVED_COLUMN


@Entity(tableName = COINS_TABLE)
class CacheCoin(
        @PrimaryKey
        @ColumnInfo(name = COIN_ID)
        var id: Int,
        var name: String,
        var symbol: String,
        var price: Double,
        var volume24h: Double,
        var percentChange1h: Double,
        var percentChange24h: Double,
        var percentChange7d: Double,
        var marketCap: Double,
        var lastUpdated: String,
        @ColumnInfo(name = IS_OBSERVED_COLUMN)
        var isObserved: Boolean)