package slawomir.kustra.domain.test

import slawomir.kustra.domain.model.listing.Coin
import slawomir.kustra.domain.model.listing.CryptoListingResponse
import slawomir.kustra.domain.model.listing.Quote
import slawomir.kustra.domain.model.listing.UsdValue
import java.util.*

object DataFactory {

    fun randomString() = UUID.randomUUID().toString()

    fun randomDouble() = Math.random()

    fun randomInt() = Math.random().toInt()

    fun randomBoolean() = Math.random() < 0.5


    fun createCoinMock(): Coin {
        return Coin(randomInt(),
                randomString(),
                randomString(),
                randomString(),
                randomDouble(),
                randomInt(), randomInt(),
                randomString(),
                randomInt(),
                randomInt(),
                randomString(),
                Quote(UsdValue(randomDouble(), randomDouble(), randomDouble(), randomDouble(), randomDouble(), randomDouble(), randomString())))
    }

    fun createCoinsList(coinsListSize: Int): List<Coin> {
        val coins = mutableListOf<Coin>()
        repeat(coinsListSize) {
            coins.add(createCoinMock())
        }
        return coins
    }

    fun createCryptoListingResponse(coinsListSize: Int): CryptoListingResponse {
        val cryptoListingResponse = CryptoListingResponse()
        cryptoListingResponse.data = createCoinsList(coinsListSize)
        return cryptoListingResponse
    }
}