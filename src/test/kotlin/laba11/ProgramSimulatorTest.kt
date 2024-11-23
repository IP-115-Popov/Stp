package laba11

import ProgramSimulation
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
class ProgramSimulationTest {

    @Test
    fun testTheoreticalLength() {
        val n = 16
        val simulation = ProgramSimulation(n)
        val expectedTheoreticalLength = 0.9 * n * kotlin.math.ln(n.toDouble()) / kotlin.math.ln(2.0)
        assertEquals(expectedTheoreticalLength, simulation.theoreticalLength(), 0.1)
    }

    @Test
    fun testPredictedLength() {
        val n = 16
        val simulation = ProgramSimulation(n)
        val expectedPredictedLength = n * kotlin.math.ln(n.toDouble()) / kotlin.math.ln(2.0)
        assertEquals(expectedPredictedLength, simulation.predictedLength(), 0.1)
    }

    @Test
    fun testRunSimulation() {
        val n = 16
        val simulation = ProgramSimulation(n)
        val stats = simulation.runSimulation(5000)

        // Проверяем, что результаты статистики являются положительными
        assertTrue(stats["L"]!! > 0)
        assertTrue(stats["D(Ln)"]!! > 0)
        assertTrue(stats["sqrt(D(Ln))"]!! > 0)
        assertTrue(stats["q"]!! > 0)
    }

    @Test
    fun testLengthComparison() {
        val n = 32
        val simulation = ProgramSimulation(n)
        val stats = simulation.runSimulation(5000)

        val theoreticalLength = simulation.theoreticalLength()
        val simulatedLength = stats["L"]!!

        // Разница должна быть минимальной
        assertTrue(kotlin.math.abs(theoreticalLength - simulatedLength) < 15)
    }
}

