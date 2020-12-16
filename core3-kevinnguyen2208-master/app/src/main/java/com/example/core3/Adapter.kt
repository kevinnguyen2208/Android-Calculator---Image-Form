package com.example.core3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.info.view.*


class Adapter(private var locations: List<Data>)
    : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.info, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.bind(locations[position])
    }

    override fun getItemCount() = locations.size

    inner class ViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        private val city: TextView = v.findViewById(R.id.city)
        private val suburb: TextView = v.findViewById(R.id.suburb)
        private val ratingBar: RatingBar = v.findViewById(R.id.ratingBar)

        fun bind(item: Data) {
            suburb.text = item.suburb
            city.text = item.city
            if (item.city == "Australia/Melbourne") {
                ratingBar.rating = 1F
            }

            ratingBar.setOnRatingBarChangeListener { _: RatingBar, _: Float, _: Boolean ->
                if (ratingBar.rating == 1F) {
                    Toast.makeText(
                        v.context,
                        "${item.latitude}, ${item.longitude}",
                        Toast.LENGTH_LONG
                    ).show()
                } else if (ratingBar.rating == 0F) {
                    return@setOnRatingBarChangeListener
                }
            }
        }
    }
}