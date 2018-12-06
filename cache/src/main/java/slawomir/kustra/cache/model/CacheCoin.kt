package slawomir.kustra.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import slawomir.kustra.cache.Constants.COINS_TABLE_NAME


@Entity(tableName = COINS_TABLE_NAME)
class CacheCoin(
        @PrimaryKey
        var id: Int,
        var name: String,
        var symbol: String,
        var price: Double,
        var volume24h: Double,
        var percentChange1h: Double,
        var percentChange24h: Double,
        var percentChange7d: Double,
        var marketCap: Double,
        var lastUpdated: String) 