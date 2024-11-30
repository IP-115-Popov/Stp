package laba12

import kotlin.math.log2
import kotlin.math.max

// Функция для поиска минимального элемента в одномерном массиве
fun findMinElement(arr: List<Int>): Pair<Int, Int> {
    var minValue = arr[0]
    var minIndex = -1

    // Итерируем по всем элементам массива и находим минимальный
    for (i in arr.indices) {
        if (arr[i] < minValue) {
            minValue = arr[i]
            minIndex = i
        }
    }
    return Pair(minValue, minIndex)
}
// Функция сортировки массива методом пузырька
fun bubbleSort(arr: MutableList<Int>) {
    val n = arr.size
    // Два вложенных цикла для выполнения сортировки методом пузырька
    for (i in 0 until n - 1) {
        for (j in 0 until n - i - 1) {
            if (arr[j] > arr[j + 1]) {
                // Меняем местами элементы массива
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
}
// Функция бинарного поиска элемента в отсортированном массиве
fun binarySearch(arr: List<Int>, target: Int): Int {
    var left = 0
    var right = arr.size - 1

    // Ищем целевой элемент, деля массив пополам
    while (left <= right) {
        val mid = left + (right - left) / 2

        if (arr[mid] == target) {
            return mid // Если элемент найден, возвращаем его индекс
        } else if (arr[mid] < target) {
            left = mid + 1 // Ищем в правой части массива
        } else {
            right = mid - 1 // Ищем в левой части массива
        }
    }

    return -1 // Если элемент не найден, возвращаем -1
}

// Функция для поиска минимального элемента в двумерном массиве
fun findMinElement2D(arr: List<List<Int>>): Triple<Int, Int, Int> {
    var minValue = Int.MAX_VALUE
    var minRow = -1
    var minCol = -1

    // Ищем минимальный элемент в двумерном массиве
    for (i in arr.indices) {
        for (j in arr[i].indices) {
            if (arr[i][j] < minValue) {
                minValue = arr[i][j]
                minRow = i
                minCol = j
            }
        }
    }

    return Triple(minValue, minRow, minCol)
}

// Функция для разворота массива в обратном порядке
fun reverseArray(arr: MutableList<Int>) {
    val temp = arr.toMutableList()
    // Перемещаем элементы в обратном порядке
    for (i in arr.indices) {
        arr[i] = temp[arr.size - 1 - i]
    }
}

// Функция для циклического сдвига массива на заданное число позиций влево
fun leftRotate(arr: MutableList<Int>, d: Int) {
    val n = arr.size
    val shift = d % n // Сдвиг в пределах массива
    // Циклически сдвигаем массив
    val rotated = arr.slice(shift until n) + arr.slice(0 until shift)
    arr.clear()
    arr.addAll(rotated)
}

// Функция для замены всех вхождений одного значения на другое
fun replaceValue(arr: MutableList<Int>, oldValue: Int, newValue: Int) {
    // Заменяем все вхождения старого значения на новое
    for (i in arr.indices) {
        if (arr[i] == oldValue) {
            arr[i] = newValue
        }
    }
}
fun findSome(nD: Double, n1: Double, n2: Double, N1: Double, N2: Double) {
    val S = 11.0 // Константа (не имеет прямого отношения к вычислениям)Ф

    val n = n1 + n2
    val N = N1 + N2

    val ngal = n1 * log2(n1) + n2 * log2(n2)
    val vD = (2 + nD) * log2(2 + nD)
    val v = N * log2(n)
    val L = vD / v
    val lgal = (2 / n1) * (n2 / N2)
    val I = (2 / n1) * (2 / N2) * (N1 + N2) * log2(n1 + n2)
    val tgal1 = (v * v) / (S * vD)
    val tgal2 = (n1 * N2 * (n1 * log2(n1) * n2 * log2(n2)) * log2(n)) / (2 * S * n2)
    val tgal3 = (n1 * N2 * N * log2(n)) / (2 * S * n2)
    val pusto1 = lgal * lgal * v
    val pusto2 = (vD * vD) / v

    // Выводим все расчеты
    println("nD $nD") //число единых по смыслу входных и выходных параметров, представленныхв сжатой без избыточной форме;
    println("n1 $n1") // - число отдельных операторов;
    println("n2 $n2") //число отдельных операндов;
    println("n $n") //- длина словаря реализации;
    println("N1 $N1") // общее число вхождений всех операторов в реализацию;
    println("N2 $N2") //- общее число вхождений всех операндов в реализацию;
    println("N $N") //длина реализации;
    println("ngal $ngal") //предсказанная длина реализации по соотношению Холстеда;
    println("vD $vD") //потенциальный объем реализации:
    println("v $v") //объем реализации:
    println("L $L") //уровень программы через потенциальный объем:

    println("lgal $lgal")//- уровень программы по реализации
    println("I $I")//- интеллектуальное содержание программы:
    println("tgal1 $tgal1")//прогнозируемое время написания программы, выраженное через потенциальный объем
    println("tgal2 $tgal2")//прогнозируемое время написания программы, выраженное через длину
                            //реализации, найденную по Холстеду (т.е. в предположении, что программа
                            //совершенна):

    println("tgal3 $tgal3")//прогнозируемое время написания программы, выраженное через
                            // метрические характеристики реализации:

    //По всем реализациям алгоритмов определить средние значения уровней языков
    //программирования λ:
    println("pusto1 $pusto1")//
    println("pusto2 $pusto2")//
}

// Главная функция, где мы выполняем все действия с тестовыми данными
fun main() {
    //nD = 2.
//n1 = 15.
//n2 = 17.
//N1 = 34.
//N2 = 8.

//    println("=".repeat(50))
//    println("Отыскать минимальный элемент")
//    findSome(2.0, 15.0, 17.0, 34.0, 8.0)  // findMinElement
//    println("=".repeat(50))
//    println("Сортировка одномерного массива в порядке возрастания\n" +
//            "методом пузырька.")
//    findSome(2.0, 8.0, 8.0, 13.0, 15.0)  // bubbleSort
//    println("=".repeat(50))
//    println("Бинарный поиск элемента в упорядоченном одномерном\n" +
//            "массиве")
//    findSome(2.0, 7.0, 7.0, 12.0, 9.0)  // binarySearch
//    println("=".repeat(50))
//    println("Отыскать минимальный элемент двумерного массива\n" +
//            "целых, его значение и значение его индексов.")
//    findSome(3.0, 9.0, 12.0, 12.0, 12.0)  // findMinElement2D
//    println("=".repeat(50))
//    println("Осуществить перестановку значений элементов\n" +
//            "одномерного массива в обратном порядке.")
//    findSome(1.0, 4.0, 4.0, 8.0, 8.0)  // reverseArray
//    println("=".repeat(50))
//    println("Осуществлять циклический сдвиг элементов\n" +
//            "одномерного массива на заданное число позиций влево.")
//    findSome(2.0, 4.0, 4.0, 5.0, 7.0)  // leftRotate
//    println("=".repeat(50))
//    println("Заменить все вхождения целочисленного значения в\n" +
//            "целочисленный массив")
//    findSome(1.0, 5.0, 6.0, 7.0, 6.0)  // replaceValue
    findSome(2.0, 15.0, 17.0, 34.0, 8.0)
    findSome(1.0, 16.0, 19.0, 36.0, 25.0)
    findSome(3.0, 14.0, 18.0, 19.0, 24.0)
    findSome(2.0, 16.0, 21.0, 27.0, 31.0)
    findSome(1.0, 7.0, 8.0, 8.0, 12.0)
    findSome(2.0, 8.0, 10.0, 11.0, 14.0)
    findSome(3.0, 6.0, 7.0, 7.0, 9.0)
    println("=".repeat(50))
    println("с++")
    findSome(2.0, 23.0, 5.0, 46.0, 19.0);
    findSome(1.0, 19.0, 7.0, 43.0, 26.0);
    findSome(3.0, 22.0, 9.0, 53.0, 28.0);
    findSome(1.0, 25.0, 9.0, 102.0, 35.0);
    findSome(1.0, 16.0, 5.0, 54.0, 23.0);
    findSome(2.0, 16.0, 4.0, 32.0, 12.0);
    findSome(3.0, 15.0, 5.0, 22.0, 11.0);
}

