package com.example.recordatoriosg

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecordatorioAdapter(private var countries: List<Recordatorios>): RecyclerView.Adapter<RecordatorioAdapter.CountryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        val inflador = LayoutInflater.from(parent.context)

        val view = inflador.inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.render(country)

        //aquí se aplica la lógica. ej: onClickListener
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    class CountryViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val name: TextView = view.findViewById(R.id.country_name)
        val capital: TextView = view.findViewById(R.id.country_capital)
        val continent: TextView = view.findViewById(R.id.country_continent)
        val flag: ImageView = view.findViewById(R.id.country_flag)
        val image: ImageView = view.findViewById(R.id.country_image)

        fun render(recordatorios: Recordatorios) {
            name.text = recordatorios.nombre + ", "
            capital.text = recordatorios.hora
            continent.text = recordatorios.dia
            Picasso.get().load(recordatorios.image2).into(flag)
            Picasso.get().load(recordatorios.image).into(image)
        }
    }
}