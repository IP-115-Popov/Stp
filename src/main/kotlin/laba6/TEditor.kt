package laba6

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
    fun addDigit(digit : Int, mode : Mode, part : Part, position: Position) : String {
        fun editPart(digit : Int, part : String, position: Position) : String
        {
            var rez = part
            when (position) {
                Position.Start -> {
                    rez = digit.toString() + part
                }
                Position.End -> {
                    rez = part +  digit.toString()
                }
            }
            return rez
        }
        fun editMode(digit : Int, i : Double, part : Part, position: Position) : Double {
            val arr = i.toString().split('.')
            var integer = arr.get(0)
            var imaginary = arr.get(1)
            when (part) {
                Part.integer ->
                {
                    integer = editPart(digit,integer, position)
                }
                Part.imaginary ->{
                    imaginary = editPart(digit,imaginary, position)
                }
            }
            var rez = (integer + "." + imaginary).toDoubleOrNull() ?: 0.0
            return rez
        }

        when (mode) {
            Mode.real -> a = editMode(digit, a, part, position)
            Mode.imaginary -> b = editMode(digit, b, part, position)
        }
        return getNumder()
    }
    fun addZero(mode : Mode, part : Part, position: Position) = addDigit(0, mode, part, position)
    fun deleteDigitRight(mode : Mode, part : Part, position: Position) : String {
//        when (mode) {
//            Mode.real -> Math.floor(a/10)
//            Mode.imaginary -> Math.floor(b/10)
//        }
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
            1 -> addDigit(1, Mode.real, Part.integer , Position.Start)
            else -> clear()
        }
        return getNumder()
    }
    fun getNumder() : String {
        if (b < 0)
            return a.toString() + b.toString() + "i"
        else {
            return a.toString() + "+" + b.toString() + "i"
        }
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
    enum class Position() {
        Start,
        End
    }
}