package slawomir.kustra.listing.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_coins_listing.*
import slawomir.kustra.listing.injection.factory.ViewModelFactory
import slawomir.kustra.listing.mapper.UiCoinMapperImpl
import slawomir.kustra.myapplication.R
import slawomir.kustra.presentation.CoinsListingViewModel
import slawomir.kustra.presentation.model.PresentationCoin
import slawomir.kustra.presentation.state.DataState
import slawomir.kustra.presentation.state.Resource
import javax.inject.Inject

class CoinsListingActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var browseViewModel: CoinsListingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coins_listing)

        AndroidInjection.inject(this)

        browseViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(CoinsListingViewModel::class.java)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setCoinsRecycler()
    }

    private fun setCoinsRecycler() {
        coinsRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onStart() {
        super.onStart()

        browseViewModel.getCoins().observe(this,
                Observer<Resource<List<PresentationCoin>>> {
                    if (it != null) {
                        handleDataState(it)
                    }
                })
        browseViewModel.fetchCoins()
    }

    private fun handleDataState(resource: Resource<List<PresentationCoin>>) {

        val mapper = UiCoinMapperImpl()


        when (resource.state) {
            DataState.SUCCESS -> {
                progressBar.visibility = View.GONE
                val coins = resource.data?.map { mapper.mapFromPresentation(it) }
            //    Timber.e("kurwa %s", Gson().toJson(coins))

            }
            DataState.LOADING -> {
                progressBar.visibility = View.VISIBLE
            }
            DataState.ERROR -> {
                progressBar.visibility = View.GONE

            }
        }
    }
}
