package com.example.recordatoriosg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_second, container, false)
        val button= view.findViewById<Button>(R.id.first_button)
        val button2= view.findViewById<Button>(R.id.third_button)
        button.setOnClickListener{
            val  navController : NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_secondFragment_to_firstFragment)
        }
        button2.setOnClickListener{
            val  navController : NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_secondFragment_to_thirdFragment)
        }

        return  view
    }

}