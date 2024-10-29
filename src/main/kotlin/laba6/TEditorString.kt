package laba6

class TEditorString {
    var a : String = "0.0"
    var b : String = "0.0"

    //1.1+2.2i -1+2i 1-2i
    constructor(number : String) {
        setString(number)
    }
    fun isZero() : Boolean = (a.toDoubleOrNull()!!*b.toDoubleOrNull()!!) == 0.0

    fun addMinus(mode: Mode) : String {
        when (mode) {
            Mode.real -> a = "-" + a
            Mode.imaginary -> b = "-" + b
        }
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
        fun editMode(digit : Int, i : String, part : Part, position: Position) : String {
            val arr = i.split('.')
            var integer = arr.get(0)
            var imaginary = arr.getOrNull(1)
            if (imaginary == null)
            {
                when (part) {
                    Part.integer ->
                    {
                        integer = editPart(digit,integer, position)
                        return integer
                    }
                    Part.imaginary ->{
                        imaginary = ""
                        imaginary = editPart(digit,imaginary, position)
                        var rez = integer + "." + imaginary
                        return rez
                    }
                }
            }
            when (part) {
                Part.integer ->
                {
                    integer = editPart(digit,integer, position)
                }
                Part.imaginary ->{
                    imaginary = editPart(digit,imaginary, position)
                }
            }
            var rez = integer + "." + imaginary
            return rez
        }

        when (mode) {
            Mode.real -> a = editMode(digit, a, part, position)
            Mode.imaginary -> b = editMode(digit, b, part, position)
        }
        return getNumder()
    }
    fun addZero(mode : Mode, part : Part, position: Position) = addDigit(0, mode, part, position)
    fun deleteDigitRight(mode : Mode, part : Part) : String {
        fun editMode(i : String, part : Part) : String {
            val arr = i.split('.')
            var integer = arr.get(0)
            var imaginary = arr.getOrNull(1)
            if (imaginary == null) {
                when (part) {
                    Part.integer ->
                    {
                        integer = integer.dropLast(1)
                        return integer
                    }
                    Part.imaginary ->{
                        return integer
                    }
                }

            }
            when (part) {
                Part.integer ->
                {
                    integer = integer.dropLast(1)
                }
                Part.imaginary ->{
                    imaginary = imaginary.dropLast(1)
                }
            }
            var rez = integer + "." + imaginary
            return rez
        }

        when (mode) {
            Mode.real -> a = editMode(a, part)
            Mode.imaginary -> b = editMode(b, part)
        }

        return getNumder()
    }
    fun clear() : String {
        a = "0.0"
        b = "0.0"
        return getNumder()
    }
    fun edit(i : Int) : String {
        when (i) {
            0 -> addMinus(Mode.real)
            1 -> addDigit(1, Mode.real, Part.integer , Position.Start)
            else -> clear()
        }
        return getNumder()
    }
    fun getNumder() : String {
        if (b.startsWith("-"))
            return a.toString() + b.toString() + "i"
        else {
            return a.toString() + "+" + b.toString() + "i"
        }
    }
    fun setString(number : String) {
        var aa =  if (number.startsWith('-')) "-" else ""
        val trimmedNumber = number.trimStart('+','-')

        val arr = trimmedNumber.dropLast(1).split(Regex("(?=[+-])|(?<=[+-])"))

        var bb = if (arr.getOrNull(1) == "-") "-" else ""

        aa = aa + arr.getOrNull(0)
        bb = bb + arr.getOrNull(2)

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