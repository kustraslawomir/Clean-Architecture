package slawomir.kustra.domain.model.listing

open class Coin {
    constructor(id: Int?, name: String?, symbol: String?, slug: String?, circulatingSupply: Double?, totalSupply: Int?, maxSupply: Int?, dateAdded: String?, numMarketPairs: Int?, cmcRank: Int?, lastUpdated: String?, quote: Quote?) {
        this.id = id
        this.name = name
        this.symbol = symbol
        this.slug = slug
        this.circulatingSupply = circulatingSupply
        this.totalSupply = totalSupply
        this.maxSupply = maxSupply
        this.dateAdded = dateAdded
        this.numMarketPairs = numMarketPairs
        this.cmcRank = cmcRank
        this.lastUpdated = lastUpdated
        this.quote = quote
    }

    var id: Int? = null

    var name: String? = null

    var symbol: String? = null

    var slug: String? = null

    var circulatingSupply: Double? = null

    var totalSupply: Int? = null

    var maxSupply: Int? = null

    var dateAdded: String? = null

    var numMarketPairs: Int? = null

    var cmcRank: Int? = null

    var lastUpdated: String? = null

    var quote: Quote? = null

}
