package com.example.mathpractice

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import kotlin.random.Random

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */



//var secondNumber = op.generateOneDigit()
class ToplamaFragment : Fragment() {

    private var op : Operations = Operations()
    private lateinit var mContext : FragmentActivity

    private var firstNumber : Int = 0
    private var secondNumber : Int = 0
    private var result : Int  = 0

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_toplama, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mContext = requireActivity()

        reInstantiateValues()

        //var secondTv = view.findViewById<TextView>(R.id.textViewSecondNumberToplama).text

        view.findViewById<Button>(R.id.buttonCevaplaToplama).setOnClickListener {
            if (view.findViewById<EditText>(R.id.editTextCevapToplama).text.isEmpty()){
                Toast.makeText(mContext, "Bir cevap girmelisin!", Toast.LENGTH_LONG).show()
            }
            else{
                val userAnswer = view.findViewById<EditText>(R.id.editTextCevapToplama).text
                val userAns = userAnswer.toString().toInt()
                if (userAns == result){
                    Toast.makeText(mContext, "Doğru Cevap!", Toast.LENGTH_SHORT).show()
                    reInstantiateValues()
                    view.findViewById<EditText>(R.id.editTextCevapToplama).text = null
                }
                else{
                    Toast.makeText(mContext, "Yanlış Cevap!! Tekrar Dene", Toast.LENGTH_LONG).show()
                }
            }
        }

    }

    private fun reInstantiateValues(){
        this.firstNumber = op.generateMixDigit()
        this.secondNumber = op.generateMixDigit()
        this.result = op.addFunc(firstNumber, secondNumber)
        view?.findViewById<TextView>(R.id.textViewFirstNumberToplama)?.text = firstNumber.toString()
        view?.findViewById<TextView>(R.id.textViewSecondNumberToplama)?.text = secondNumber.toString()
    }

}