package slawomir.kustra.data.entity.listing

class CoinEntity(var id: Int?, var name: String?, var symbol: String?, var slug: String?, var circulatingSupply: Double?,
                 var totalSupply: Int?, var maxSupply: Int?, var dateAdded: String?, var numMarketPairs: Int?,
                 var cmcRank: Int?, var lastUpdated: String?, var quote: QuoteEntity?)

