package slawomir.kustra.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Quote {

    @SerializedName("USD")
    @Expose
    var usd: USD? = null

}
