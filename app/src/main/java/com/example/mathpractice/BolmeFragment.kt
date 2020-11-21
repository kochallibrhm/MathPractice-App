package com.example.mathpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlin.random.Random


class BolmeFragment : Fragment() {
    private var op : Operations = Operations()
    private lateinit var mContext : FragmentActivity

    private var firstNumber : Int = 0
    private var secondNumber : Int = 0
    private var result  : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bolme, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mContext = requireActivity()

        reInstantiateValues()


        view.findViewById<Button>(R.id.buttonCevaplaBolme).setOnClickListener {

            if (view.findViewById<EditText>(R.id.editTextCevapBolme).text.isEmpty()){
                Toast.makeText(mContext, "Bir cevap girmelisin!", Toast.LENGTH_LONG).show()
            }
            else{
                val userAnswer = view.findViewById<EditText>(R.id.editTextCevapBolme).text
                val userAns = userAnswer.toString().toInt()
                if (userAns == result){
                    Toast.makeText(mContext, "Doğru Cevap!", Toast.LENGTH_SHORT).show()
                    reInstantiateValues()
                    view.findViewById<EditText>(R.id.editTextCevapBolme).text = null
                }
                else{
                    Toast.makeText(mContext, "Yanlış Cevap!! Tekrar Dene", Toast.LENGTH_LONG).show()
                }
            }
        }

    }

    private fun reInstantiateValues(){
        this.firstNumber = op.generateMixDigit()

        when (Random.nextInt(0, 2)){
            1 -> this.secondNumber = op.generateMixDigit()
            0 -> this.secondNumber = op.generateOneDigit()
        }

        while (secondNumber == 0){secondNumber = op.generateOneDigit()}

        this.firstNumber = op.makeDivisible(firstNumber, this.secondNumber)
        this.result = op.divFunc(firstNumber, secondNumber)
        view?.findViewById<TextView>(R.id.textViewFirstNumberBolme)?.text = firstNumber.toString()
        view?.findViewById<TextView>(R.id.textViewSecondNumberBolme)?.text = secondNumber.toString()
    }
}