package slawomir.kustra.data.mapper

interface EntityMapper<E, D> {

    fun mapToEntity(domain: D): E
}