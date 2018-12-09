package slawomir.kustra.listing.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_coins_listing.*
import slawomir.kustra.listing.activity.adapter.CoinsAdapter
import slawomir.kustra.listing.injection.factory.ViewModelFactory
import slawomir.kustra.myapplication.R
import slawomir.kustra.presentation.CoinsListingViewModel
import slawomir.kustra.presentation.model.UiCoin
import slawomir.kustra.presentation.state.Resource
import slawomir.kustra.presentation.state.ResponseState
import timber.log.Timber
import javax.inject.Inject

class CoinsListingActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var browseViewModel: CoinsListingViewModel
    private val adapter = CoinsAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coins_listing)

        AndroidInjection.inject(this)

        browseViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(CoinsListingViewModel::class.java)
        setCoinsRecycler()
    }

    override fun onStart() {
        super.onStart()

        browseViewModel.getCoins().observe(this,
                Observer<Resource<List<UiCoin>>> {
                    Timber.e("it == null %s", it == null)
                    if (it != null) {
                        handleDataState(it)
                    }
                })
        browseViewModel.fetchCoins()
    }

    private fun setCoinsRecycler() {
        coinsRecyclerView.layoutManager = LinearLayoutManager(this)
        coinsRecyclerView.adapter = adapter
    }

    private fun handleDataState(resource: Resource<List<UiCoin>>) {
        Timber.e("data: %s", Gson().toJson(resource))
        when (resource.state) {
            ResponseState.SUCCESS -> {
                progressBar.visibility = View.GONE

                val coins = resource.data
                if(coins!=null)
                    adapter.setCoins(coins)
            }
            ResponseState.LOADING -> {
                progressBar.visibility = View.VISIBLE
            }
            ResponseState.ERROR -> {
                progressBar.visibility = View.GONE

            }
        }
    }
}
