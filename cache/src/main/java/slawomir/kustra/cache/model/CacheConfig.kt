package slawomir.kustra.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import slawomir.kustra.cache.Constants.CACHE_CONFIG_TABLE

@Entity(tableName =  CACHE_CONFIG_TABLE)
class CacheConfig(val lastCacheTime: Long) {

    @PrimaryKey
    var key = 1

}