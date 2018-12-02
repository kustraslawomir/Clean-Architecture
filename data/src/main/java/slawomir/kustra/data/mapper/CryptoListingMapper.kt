package slawomir.kustra.data.mapper

import slawomir.kustra.data.entity.listing.*
import slawomir.kustra.domain.model.listing.*

class CryptoListingMapper : EntityMapper<CryptoListingEntity, CryptoListingResponse> {

    override fun mapToEntity(domain: CryptoListingResponse): CryptoListingEntity {
        return CryptoListingEntity(mapStatus(domain.status), mapData(domain.data))
    }

    private fun mapStatus(status: Status?): StatusEntity {
        return StatusEntity(status?.errorCode, status?.errorMessage)
    }

    private fun mapData(data: List<Coin>?): List<CoinEntity>? {
        val coinsEntities = mutableListOf<CoinEntity>()

        if (data != null && !data.isEmpty()) {
            data.forEach { coin -> coinsEntities.add(mapCoin(coin)) }
        }
        return coinsEntities
    }

    private fun mapCoin(coin: Coin) = CoinEntity(coin.id, coin.name, coin.symbol, coin.totalSupply, mapQuote(coin.quote))

    private fun mapQuote(quote: Quote?) = QuoteEntity(mapUsdValue(quote?.usd))

    private fun mapUsdValue(usd: UsdValue?): UsdValueEntity? {
        return if (usd != null) {
            UsdValueEntity(usd.price, usd.volume24h, usd.percentChange1h, usd.percentChange24h, usd.percentChange7d, usd.marketCap)
        } else UsdValueEntity(0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    }
}