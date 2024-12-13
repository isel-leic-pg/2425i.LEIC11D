

fun fact(n: Int): Long =
    if (n==0) 1L
    else n * fact(n-1)

fun main() {
    println(fact(4)) // 24
    println(fact(10))
    println(Int.MAX_VALUE)
    println(fact(20))
}