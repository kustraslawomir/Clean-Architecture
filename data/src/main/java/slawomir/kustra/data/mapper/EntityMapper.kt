package slawomir.kustra.data.mapper

interface EntityMapper<E, D> {

    fun mapFromEntity(entity : E) : D
}