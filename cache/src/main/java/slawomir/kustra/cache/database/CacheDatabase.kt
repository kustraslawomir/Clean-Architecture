package slawomir.kustra.cache.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import slawomir.kustra.cache.Constants.COINS_DATABASE_NAME
import slawomir.kustra.cache.dao.CacheConfigDao
import slawomir.kustra.cache.dao.CoinsDao
import slawomir.kustra.cache.model.CacheCoin
import slawomir.kustra.cache.model.CacheConfig


@Database(entities = [CacheCoin::class, CacheConfig::class], version = 1, exportSchema = false)
abstract class CacheDatabase : RoomDatabase() {

    abstract fun coinsDao(): CoinsDao

    abstract fun cacheConfigDao() : CacheConfigDao

    companion object {
        private var database: CacheDatabase? = null

        fun getDatabase(context: Context): CacheDatabase {
            if (database == null)
                database = Room.databaseBuilder(context.applicationContext, CacheDatabase::class.java, COINS_DATABASE_NAME)
                        .build()
            return database as CacheDatabase
        }
    }
}