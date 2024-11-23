package laba9

data class TMember(
    var c: Double,
    var n: Int
) {
    fun readDegree() = n
    fun writeDegree(n: Int) {
        this.n = n
        require(this.n == n) { " this.n = n" }
    }

    fun writeRatio(c: Double) {
        this.c = c
        require(this.c == c) { " this.c == c" }
    }

    fun equally(q: TMember): Boolean =
        Math.pow(q.c, q.n.toDouble()) == Math.pow(this.c, this.n.toDouble())

    fun Differentiate() = TMember(c * n, n - 1)

    fun Calculate(x: Double): Double = c * Math.pow(x, n.toDouble())

    operator fun times(other: TMember) : TMember = TMember(this.c*other.c, this.n +other.n)
}