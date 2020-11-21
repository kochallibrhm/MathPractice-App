package com.example.mathpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_toplama).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_ToplamaFragment)
        }

        view.findViewById<Button>(R.id.button_cikarma).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_Cikarma)
        }

        view.findViewById<Button>(R.id.button_carpma).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_Carpma)
        }

        view.findViewById<Button>(R.id.button_bölme).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_Bolme)
        }
    }
}