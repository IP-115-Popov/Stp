import kotlin.math.ln
import kotlin.math.sqrt
import kotlin.random.Random

class ProgramSimulation(val n: Int) {

    // Метод для симуляции написания программы
    fun simulate(): Int {
        val dictionary = MutableList(n) { it + 1 } // 1..n - словарь
        val selected = mutableSetOf<Int>() // Множество для уникальных выбранных символов
        var numDraws = 0

        while (selected.size < n) {
            val drawn = dictionary.random() // случайный выбор элемента из словаря
            selected.add(drawn) // добавляем в множество
            numDraws++
        }
        return numDraws
    }

    // Метод для вычисления статистики
    fun runSimulation(trials: Int): Map<String, Double> {
        val lengths = mutableListOf<Int>()
        for (i in 0 until trials) {
            lengths.add(simulate())
        }

        val mean = lengths.average()
        val variance = lengths.map { (it - mean).pow(2) }.average()
        val stdDev = sqrt(variance)
        val relativeError = stdDev / mean

        return mapOf(
            "L" to mean,
            "D(Ln)" to variance,
            "sqrt(D(Ln))" to stdDev,
            "q" to relativeError
        )
    }

    // Теоретическое значение длины программы
    fun theoreticalLength(): Double {
        return 0.9 * n * ln(n.toDouble()) / ln(2.0)
    }

    // Теоретическая дисперсия
    fun theoreticalVariance(): Double {
        return (Math.PI.pow(2) * n.pow(2)) / 6
    }

    // Метод для получения прогнозируемой длины программы
    fun predictedLength(): Double {
        return n * ln(n.toDouble()) / ln(2.0)
    }
}

// Расширение для возведения в степень
fun Double.pow(exponent: Int): Double {
    return Math.pow(this, exponent.toDouble())
}
fun Int.pow(exponent: Int): Double {
    return this.toDouble().pow(exponent)
}
fun main() {
    val n = 16
    val simulation = ProgramSimulation(n)

    // Запуск симуляции с 1000 испытаниями
    val trials = 1000
    val stats = simulation.runSimulation(trials)

    println("Статистика для n = $n:")
    println("Длина программы (L): ${stats["L"]}")
    println("Дисперсия длины программы (D(Ln)): ${stats["D(Ln)"]}")
    println("Среднеквадратическое отклонение (sqrt(D(Ln))): ${stats["sqrt(D(Ln))"]}")
    println("Относительная погрешность (q): ${stats["q"]}")

    // Теоретическое значение длины программы
    println("Теоретическая длина программы: ${simulation.theoreticalLength()}")
    println("Прогнозируемая длина программы: ${simulation.predictedLength()}")

    // Сравнение с теоретическим значением
    val lengthFromFormula = simulation.theoreticalLength()
    val lengthFromSimulation = stats["L"]!!
    println("Разница между теоретической длиной и длиной из симуляции: ${lengthFromFormula - lengthFromSimulation}")
}