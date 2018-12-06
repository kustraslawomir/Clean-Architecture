package slawomir.kustra.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CyrptoListingsResponse {

    @SerializedName("status")
    @Expose
    var status: Status? = null
    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null

}
