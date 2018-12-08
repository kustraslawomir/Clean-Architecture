package slawomir.kustra.listing.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_coins_listing.*
import slawomir.kustra.myapplication.R

class CoinsListingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coins_listing)
        setCoinsRecycler()
    }

    private fun setCoinsRecycler() {
        coinsRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}
