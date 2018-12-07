package slawomir.kustra.domain.model.listing

open class Coin(var id: Int, var name: String, var symbol: String, var price: Double, var volume24h: Double, var percentChange1h: Double,
                var percentChange24h: Double, var percentChange7d: Double,
                var marketCap: Double, var lastUpdated: String, var isObserved: Boolean)

