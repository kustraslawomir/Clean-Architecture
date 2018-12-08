package slawomir.kustra.listing.activity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import slawomir.kustra.listing.model.UiCoin
import slawomir.kustra.myapplication.R

class CoinsAdapter(private val coins: List<UiCoin>) : RecyclerView.Adapter<CoinsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_coin, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val coin = coins[position]
        holder.coinName.text = coin.name
    }

    override fun getItemCount() = coins.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val coinName = itemView.findViewById<TextView>(R.id.coinName)
    }

}