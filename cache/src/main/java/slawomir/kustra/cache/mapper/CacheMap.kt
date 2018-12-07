package slawomir.kustra.cache.mapper

interface CacheMap<C, E> {

    fun mapFromCached(type: C): E

    fun mapToCached(type: E): C
}