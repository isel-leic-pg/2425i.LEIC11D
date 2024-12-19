fun main() {
    val a = Array(10) { (1..99).random() }
    println(a.toList())
    insertionSort(a)
    println(a.toList())
}

/**
 * Algoritmo de ordenação usando Insertion Sort.
 * - Com trocas sucessivas sem parar a passagem.
 */
fun insertionSortA(a: Array<Int>) {
    for (i in 1 ..< a.size)
        for (j in i downTo 1)
            if (a[j] < a[j-1]) {
                val tmp = a[j]
                a[j] = a[j-1]
                a[j-1] = tmp
            }
}

/**
 * Algoritmo de ordenação usando Insertion Sort.
 * - Termina a passagem antecipadamente.
 */
fun insertionSortB(a: Array<Int>) {
    for (i in 1 ..< a.size) {
        var j = i
        while (j > 0 && a[j] < a[j-1]) {
            val tmp = a[j]
            a[j] = a[j-1]
            a[--j] = tmp
        }
    }
}

/**
 * Algoritmo de ordenação usando Insertion Sort
 * - Com deslocamento em vez de fazer trocas sucessivas.
 */
fun insertionSort(a: Array<Int>) {
    for (i in 1..<a.size) {
        val tmp = a[i]
        var j = i
        while (j > 0 && a[j-1] > tmp) {
            a[j] = a[j-1]
            j--
        }
        a[j] = tmp
    }
}