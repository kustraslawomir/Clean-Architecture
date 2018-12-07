package slawomir.kustra.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import io.reactivex.Single
import slawomir.kustra.cache.Constants.CACHE_CONFIG_TABLE
import slawomir.kustra.cache.model.CacheConfig

@Dao
abstract class CacheConfigDao() {

    @Query("SELECT * FROM $CACHE_CONFIG_TABLE")
    abstract fun getCacheTime(): Single<CacheConfig>

    @Insert(onConflict = REPLACE)
    abstract fun insertCacheTime(cacheTime: Long)

    @Query("DELETE * FROM $CACHE_CONFIG_TABLE")
    abstract fun clearCache()
}