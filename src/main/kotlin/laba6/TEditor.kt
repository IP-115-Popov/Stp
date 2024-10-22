package laba6

import kotlin.contracts.contract

class TEditor {
    var a : Double = 0.0
    var b : Double = 0.0

    //1.1+2.2i -1+2i 1-2i
    constructor(number : String) {
        setString(number)
    }
    fun isZero() : Boolean = (a * b == 0.0)
    fun addMinus() : String {
        //-1*(a+b)
        a *= -1
        b *= -1
        return getNumder()
    }
    fun addDigit(digit : Int, mode : Mode) : String {
        when (mode) {
            Mode.real -> a*10 + digit
            Mode.imaginary -> b*10 + digit
        }
        return getNumder()
    }
    fun addZero(mode : Mode) = addDigit(0, mode)
    fun deleteDigitRight(mode : Mode) : String {
        when (mode) {
            Mode.real -> Math.floor(a/10)
            Mode.imaginary -> Math.floor(b/10)
        }
        return getNumder()
    }
    fun clear() : String {
        a = 0.0
        b = 0.0
        return getNumder()
    }
    fun edit(i : Int) : String {
        when (i) {
            0 -> addMinus()
            1 -> addDigit(1, Mode.real)
            2 -> addDigit(1, Mode.imaginary)
            else -> clear()
        }
        return getNumder()
    }
    fun getNumder() : String {
        return a.toString() + b.toString() + "i"
    }
    fun setString(number : String) {
        var aa =  if (number.startsWith('-')) -1.0 else 1.0
        val trimmedNumber = number.trimStart('+','-')

        val arr = trimmedNumber.dropLast(1).split(Regex("(?=[+-])|(?<=[+-])"))

        var bb = if (arr.getOrNull(1) == "-") -1.0 else 1.0

        aa *= arr.getOrNull(0)?.toDoubleOrNull() ?: 0.0
        bb *= arr.getOrNull(2)?.toDoubleOrNull() ?: 0.0

        this.a = aa
        this.b = bb
    }
    enum class Mode() {
        real,
        imaginary
    }
    enum class Part() {
        integer,
        imaginary
    }
}