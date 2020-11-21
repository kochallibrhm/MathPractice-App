package com.example.mathpractice

import kotlin.random.Random

class Operations {

    public fun generateOneDigit() : Int {
        return Random.nextInt(0,10)
    }

    public fun generateTwoDigit() : Int {
        return Random.nextInt(10,100)
    }

    public fun generateMixDigit() : Int {
        return Random.nextInt(0,100)
    }

    public fun addFunc(first: Int, second: Int): Int {
        return first + second
    }

    public fun minusFunc(first: Int, second: Int) : Int {
        return first - second
    }

    public fun multiFunc(first: Int, second: Int) : Int {
        return first * second
    }

    public fun divFunc(first: Int, second: Int) : Int {
        return first / second
    }

    // We used max func instead of this func
    public fun isBig(first: Int, second: Int): Boolean {
        if (first > second) { return true}
        return false
    }

    public fun isDivisible(first: Int, second: Int): Boolean{
        if ( first % second == 0 ) {
            return true
        }
        return false
    }

    public fun makeDivisible(first: Int, second: Int) : Int {
        val remaining = first % second
        val addition = second - remaining
        return first + addition
    }


}


