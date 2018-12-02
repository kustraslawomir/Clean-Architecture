package slawomir.kustra.domain.model.listing


open class Quote {

    constructor(usd: UsdValue?) {
        this.usd = usd
    }

    var usd: UsdValue? = null

}
