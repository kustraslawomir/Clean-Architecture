package slawomir.kustra.data.mapper

import slawomir.kustra.data.entity.listing.*
import slawomir.kustra.domain.model.listing.*

class CoinsLxistingMapper : EntityMapper<CryptoListingEntity, CryptoListingResponse> {

    override fun mapFromEntity(entity: CryptoListingEntity): CryptoListingResponse {
            return CryptoListingResponse(mapStatus(entity.status), mapData(entity.data))
    }

    private fun mapStatus(status: StatusEntity?): Status {
        return Status(status?.errorCode, status?.errorMessage)
    }

    private fun mapData(data: List<CoinEntity>?): List<Coin>? {
        val coinsEntities = mutableListOf<Coin>()

        if (data != null && !data.isEmpty()) {
            data.forEach { coin -> coinsEntities.add(mapCoin(coin)) }
        }
        return coinsEntities
    }

    private fun mapCoin(coin: CoinEntity) = Coin(coin.id, coin.name, coin.symbol,  mapQuote(coin.quote))

    private fun mapQuote(quote: QuoteEntity?) = Quote(mapUsdValue(quote?.usd))

    private fun mapUsdValue(usd: UsdValueEntity?): UsdValue? {
        return if (usd != null) {
            UsdValue(usd.price, usd.volume24h, usd.percentChange1h, usd.percentChange24h, usd.percentChange7d, usd.marketCap)
        } else UsdValue(0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    }

}