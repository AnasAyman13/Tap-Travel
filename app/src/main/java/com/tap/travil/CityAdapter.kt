package com.tap.travil

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.tap.travil.R.*

class CityAdapter (val activity : Activity, val cities: ArrayList<cities>):
        RecyclerView.Adapter<CityAdapter.MVH>(){
        class MVH(view: View): RecyclerView.ViewHolder(view) {
                val parent: CardView =view.findViewById(id.parent)
                val iv : ImageView =view.findViewById(id.image)
                val tv : TextView =view.findViewById(id.tv)

        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityAdapter.MVH {
              val view = activity.layoutInflater.inflate(layout.cities_list_item, parent,false)
                return MVH(view)
        }

        override fun onBindViewHolder(holder: CityAdapter.MVH, position: Int) {
                holder.iv.setImageResource(cities[position].pic)
                holder.tv.text = cities[position].name

                holder.parent.setOnClickListener {
                        val url = cities[position].url
                        val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        holder.itemView.context.startActivity(i)

                }
        }

        override fun getItemCount() = cities.size

}
