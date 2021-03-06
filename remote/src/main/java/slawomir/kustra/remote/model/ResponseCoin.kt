package slawomir.kustra.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseCoin {

    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("symbol")
    @Expose
    var symbol: String? = null
    @SerializedName("slug")
    @Expose
    var slug: String? = null
    @SerializedName("circulating_supply")
    @Expose
    var circulatingSupply: Double? = null
    @SerializedName("total_supply")
    @Expose
    var totalSupply: Double? = null
    @SerializedName("max_supply")
    @Expose
    var maxSupply: Any? = null
    @SerializedName("date_added")
    @Expose
    var dateAdded: String? = null
    @SerializedName("num_market_pairs")
    @Expose
    var numMarketPairs: Int? = null
    @SerializedName("tags")
    @Expose
    var tags: List<String>? = null
    @SerializedName("platform")
    @Expose
    var platform: Platform? = null
    @SerializedName("cmc_rank")
    @Expose
    var cmcRank: Int? = null
    @SerializedName("last_updated")
    @Expose
    var lastUpdated: String? = null
    @SerializedName("quote")
    @Expose
    var quote: Quote? = null
}
