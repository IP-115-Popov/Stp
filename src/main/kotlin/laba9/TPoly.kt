package laba9

class TPoly {
    var poly = mutableListOf<TMember>()

    constructor(c: Double, n: Int) {
        poly += TMember(c, n)
    }

    fun Degree(): Int = poly.maxOf { it.n }

    fun Ratio(n: Int): Double {
        require(poly.all { it.c != 0.0 }) { "Ratio Нулевой полином" }

        val rez = poly.find { it.n == n }

        if (rez == null || n > rez.c)
            return 0.0
        else
            return rez.c
    }

    fun Clear() = poly.clear()

    operator fun plus(other: TPoly) : TPoly {
        val map1 = this.poly.groupBy { it.n }
        val map2 = other.poly.groupBy { it.n }

        val result = mutableListOf<TMember>()

        (map1.keys + map2.keys).distinct().forEach { n ->
            val members = mutableListOf<TMember>()

            map1[n]?.let { members.addAll(it) }
            map2[n]?.let { members.addAll(it) }

            if (members.isNotEmpty()) {
                val summedMember = members.reduce { acc, member ->
                    TMember(acc.c + member.c, n)
                }
                result.add(summedMember)
            }
        }

        val r = TPoly(0.0,0)
        r.poly = result
        return r
    }
    operator fun minus(other: TPoly) : TPoly = this + other.timesMinus()

    operator fun times(other: TPoly) : TPoly {

        var result = mutableListOf<TMember>()

        for (i in poly) {
            for (j in other.poly)
            {
                result += i*j
            }
        }

        val result2 = result.groupBy { it.n }.map { it ->
            TMember(
                it.value.fold(0.0){acc: Double, tMember: TMember ->  acc + tMember.c},
                it.key
            )
            //it.key to it.value.fold(1.0){acc: Double, tMember: TMember ->  acc * tMember.c}
        }

        val r = TPoly(0.0,0)
        r.poly = result2.toMutableList()
        return r
    }

    fun timesMinus() : TPoly {
        val r = TPoly(0.0,0)
        r.poly = poly.map { it.copy(c = -it.c) }.toMutableList()
        return r
    }

    fun equally(other: TPoly) :Boolean {
        if (poly.size != other.poly.size) return false
        return poly.zip(other.poly).all { (member1, member2) -> member1 == member2 } //zip возврашяет обект (member1, member2) //all весль списко обектов соотвецтыует условию
    }
    fun Differentiate() : TPoly {
        val r = TPoly(0.0,0)
        r.poly = poly.map { it.Differentiate() }.toMutableList()
        return r
    }
    fun Calculate(x: Double): Double =
        poly.map { it.Calculate(x) } //шитаем заначение ддля каждого
            .sum() //сумируем
    fun Element(i : Int) = poly[i]
}