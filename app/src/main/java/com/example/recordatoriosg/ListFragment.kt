package com.example.recordatoriosg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    private var countries : MutableList<Recordatorios> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val fab = view.findViewById<FloatingActionButton>(R.id.fab_new)
        initData()

        val adapter = RecordatorioAdapter(countries)

        val recyclerView =
            view.findViewById<RecyclerView>(
                R.id.countriesRecycler
            )



        //Variables para el elemento nuevo
        var _id : Int = 0
        var _name : String
        var _capital : String
        var _continent : String
        var _flag : String
        var _image : String

        fab.setOnClickListener {


            // Show Bottom Sheet Dialog and add a new item
            val bottomSheetFragment =BottomSheetDialog(view.context)
            val parentView : View = layoutInflater.inflate(R.layout.bsd_new_country, null)
            bottomSheetFragment.setContentView(parentView)
            bottomSheetFragment.show()

            //elementos del formulario bsd
            val newId = parentView.findViewById<EditText>(R.id.bsd_country_id)
            val newName = parentView.findViewById<EditText>(R.id.bsd_country_name)
            val newCapital = parentView.findViewById<EditText>(R.id.bsd_country_capital)
            val newFlag = parentView.findViewById<EditText>(R.id.bsd_country_flag)
            val newImage = parentView.findViewById<EditText>(R.id.bsd_country_image)
            val newContinent = parentView.findViewById<EditText>(R.id.bsd_country_continent)

            val button = parentView.findViewById<Button>(R.id.AGREGAR)

            //boton guardar del bsd, asignación de valores y creación del nuevo elemento
            button.setOnClickListener{
                _id = newId.text.toString().toInt()
                _name = newName.text.toString()
                _capital = newCapital.text.toString()
                _flag = newFlag.text.toString()
                _image = newImage.text.toString()
                _continent = newContinent.text.toString()

                val newProductAdd = Recordatorios(
                    _id,
                    _name,
                    _capital,
                    _continent,
                    _flag,
                    _image
                )

                countries.add(newProductAdd)

                recyclerView.adapter?.notifyDataSetChanged()

                bottomSheetFragment.dismiss()
            }
        }

        //Lista anchura completa
        //val layoutManager = LinearLayoutManager(container?.context)
        //Cuadricula 2X2
        val gridLayoutManager = GridLayoutManager(container?.context, 2)

        //recyclerView?.layoutManager = layoutManager
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.adapter = adapter

        return view
    }

    private fun initData() {

        countries = mutableListOf(
            Recordatorios(1, "Cita con el dentista", "a las 12:30pm", "12:30PM", "https://img.freepik.com/vector-premium/campana-dorada-amarilla-numero-recordatorio-aislado-sobre-fondo-blanco-senal-notificacion_3482-7815.jpg?w=2000", "https://i.pinimg.com/474x/81/80/d1/8180d148b616b78905fa80b95e2f0f12.jpg"),
            Recordatorios(2, "Cita con las de las uñas", "alas 10:00AM", "a las 10:00AM", "https://img.freepik.com/vector-premium/senal-notificacion-recordatorio-realista-campana-sonando_316839-3491.jpg", "https://www.parati.com.ar/wp-content/uploads/2023/03/unas-minimalistas-2.jpeg.webp"),
            Recordatorios(3,"Cita con los amigos","Paris","a las 7:20PM","https://img.freepik.com/vector-premium/senal-notificacion-recordatorio-realista-campana-sonando_316839-3491.jpg", "https://images.ecestaticos.com/XQcI9ZiyTtr9d5YLReDLA3cCLsI=/0x0:2214x1354/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2Fbcf%2F728%2Ff2e%2Fbcf728f2ed68be695d81410ea2dce9e8.jpg"),
            Recordatorios(4, "Cita con el jongkook", "London", "A las 10:00PM", "https://img.freepik.com/vector-premium/senal-notificacion-recordatorio-realista-campana-sonando_316839-3491.jpg", "https://heraldodemexico.com.mx/u/fotografias/m/2023/4/20/f768x1-715018_715145_40.jpg"),
            Recordatorios(5, "cita con el nutriologo", "Rome", "Alas 11:10AM", "https://img.freepik.com/vector-premium/senal-notificacion-recordatorio-realista-campana-sonando_316839-3491.jpg", "https://comedores-industriales.com.mx/wp-content/uploads/2021/01/dia-del-nutriologio.jpg"),
            Recordatorios(6, "dia para aprobar el examen", "Tokyo", "a las 2:20PM", "data:image/jpeg;base64,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", "https://preview.redd.it/cuando-tengo-un-examen-v0-ayvpg5r25sv91.jpg?width=514&format=pjpg&auto=webp&s=7b89678656729ac980e43bd503fcb3ed3cb5c63e"),
            Recordatorios(7,"Cita para ir al cine", "Ontario", "A las 5:25PM", "https://img.freepik.com/vector-premium/senal-notificacion-recordatorio-realista-campana-sonando_316839-3491.jpg", "https://us.123rf.com/450wm/estradaanton/estradaanton1805/estradaanton180500416/101330425-la-gente-asombrada-y-sorprendida-est%C3%A1-sentada-en-una-fila-y-viendo-una-pel%C3%ADcula-chica-rubia-est%C3%A1.jpg?ver=6"),
            Recordatorios(8, "Citas para ir con el dermatologo", "A las 4:30", "Alas 4:30PM", "https://img.freepik.com/vector-premium/senal-notificacion-recordatorio-realista-campana-sonando_316839-3491.jpg", "https://img.freepik.com/vector-premium/ilustracion-concepto-dermatologo-estilo-dibujos-animados_277904-10124.jpg")
        )
    }
}