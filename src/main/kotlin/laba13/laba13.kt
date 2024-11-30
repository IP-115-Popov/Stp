package laba13

import kotlin.math.*

val n = 5 // Количество программистов
val v = 20 // Количество отлаженных в день команд ассемблера

// Функция для вычисления i (число уровней иерархии)
fun I(eta: Int): Int {
    return (log2(eta.toDouble()) / 3 + 1).toInt()
}

// Функция для вычисления k (число модулей нижнего уровня)
fun K(eta: Int, i: Int): Int {
    var result = 1.0
    for (j in 1 until i) {
        result += eta / 8.0.pow(j)
    }
    return result.toInt()
}

// Функция для вычисления eta * log2(eta)
fun eta2KFunc(eta: Int): Double {
    return eta * log2(eta.toDouble())
}

// Функция для вычисления 2 * eta * log2(eta)
fun NkFunc(eta: Double): Double {
    return 2 * eta * log2(eta)
}

// Функция для вычисления N = k * Nk
fun NFunc(k: Int, Nk: Double): Double {
    return k * Nk
}

// Функция для вычисления объема V = k * Nk * log2(2 * eta)
fun VFunc(k: Int, Nk: Double, eta: Double): Double {
    return k * Nk * log2(2 * eta)
}

// Функция для вычисления длины программы P
fun PFunc(N: Double): Double {
    return 3 * N / 8
}

// Функция для вычисления календарного времени T = P / (n * v)
fun TFunc(P: Double): Double {
    return P / (n * v)
}

// Функция для вычисления начального количества ошибок B = V / 3000
fun BFunc(V: Double): Double {
    return V / 3000
}

// Функция для вычисления времени отладки tau = T / 2
fun tauFunc(T: Double): Double {
    return T / 2
}

// Функция для вычисления надежности tн = tau / log(B)
fun tnFunc(tau: Double, B: Double): Double {
    return tau / Math.log(B)
}

fun main() {
    // Тестируем для различных значений eta
    val etaArray = arrayOf(8, 300, 400, 512)

    for (eta in etaArray) {
        println("===============================================")

        // Вычисления по заданным формулам
        val i = I(eta)
        val k = K(eta, i)
        val eta2k = eta2KFunc(eta)
        val Nk = NkFunc(eta2k)
        val N = NFunc(k, Nk)
        val V = VFunc(k, Nk, eta2k)
        val P = PFunc(N)
        val T = TFunc(P)
        val B = BFunc(V)
        val tau = tauFunc(T)
        val tn = tnFunc(tau, B)

        // Вывод результатов для текущего значения eta
        println("eta = $eta")
        println("i = $i")
        println("k = $k")
        println("eta2k = $eta2k")
        println("Nk = $Nk")
        println("N = $N")
        println("V = $V")
        println("P = $P")
        println("T = $T")
        println("B = $B")
        println("tau = $tau")
        println("tn = $tn")
    }
}
