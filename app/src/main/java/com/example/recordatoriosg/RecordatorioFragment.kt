package com.example.recordatoriosg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class RecordatorioFragment : BottomSheetDialogFragment() {

    interface OnItemAddedListener {
        fun onItemAddedListener(newItem: Recordatorios)
    }

    private var itemAddedListener: OnItemAddedListener? = null

    fun setOnItemAddedListener(listener: Recordatorios) {
        itemAddedListener
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bsd_new_country, container, false)

        val button = view.findViewById<Button>(R.id.AGREGAR)

        button.setOnClickListener {
            val recordatorios = Recordatorios(
                9,
                "cita para ir al doctor",
                "12:00PM",
                "hoy",
                "https://w7.pngwing.com/pngs/192/306/png-transparent-computer-icons-encapsulated-postscript-notification-miscellaneous-hat-bell.png",
                "https://i.pinimg.com/736x/5c/08/41/5c0841d484e1a85ccdde749e5e2a888b.jpg")
            itemAddedListener?.onItemAddedListener(recordatorios)
            dismiss()
        }

        return view
    }
}