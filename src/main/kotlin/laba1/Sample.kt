package ru.sergey.learn2.laba1

class Sample() {
    fun sum(aArray : IntArray, bArray : IntArray)
         = if (aArray.isNotEmpty() || aArray.size == bArray.size)
             aArray.mapIndexed { index, i ->  i + bArray[index] }
            else intArrayOf()

    fun shiftLeft(array: DoubleArray, shift: Int) : DoubleArray {
        val n = array.size
        if (n == 0 || shift % n == 0) return array // Если массив пустой или сдвиг кратен длине массива, ничего не делаем

        // Нормализуем сдвиг, чтобы он не превышал длину массива
        val effectiveShift = (shift % n + n) % n

        // Создаем новый массив для хранения сдвинутых значений
        val result = DoubleArray(n)

        // Заполняем новый массив с учетом циклического сдвига
        for (i in array.indices) {
            result[i] = array[(i + effectiveShift) % n]
        }
        return  result
    }
    fun findSubsequenceIndex(vec: IntArray, seq: IntArray): Int {
        if (seq.isEmpty()) return 0 // Если последовательность seq пуста, возврат 0
        if (vec.size < seq.size) return -1 // Если vec меньше seq, возврат -1

        for (i in vec.indices) {
            // Проверяем, достаточно ли длины vec для поиска seq
            if (i + seq.size <= vec.size) {
                var found = true

                // Проверяем последовательность
                for (j in seq.indices) {
                    if (vec[i + j] != seq[j]) {
                        found = false
                        break
                    }
                }

                if (found) {
                    return i // Возвращаем индекс первого вхождения
                }
            }
        }
        return -1 // Если не найдено
    }
}