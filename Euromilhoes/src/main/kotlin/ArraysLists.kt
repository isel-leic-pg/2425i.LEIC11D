fun mutableListTest() {
    val ml = mutableListOf(34,56,2)
    println(ml)
    ml.add(35)
    ml.removeAt(1)
    println(ml)
    val r = ml.filter { it%2==0 }
    println(ml)
    println(r)
    val ml2 = r.toMutableList()
    ml2.add(0,45)
    println(ml2)
    val l: List<Int> = ml
}

fun main(args: Array<String>) {
    println(args.toList())

    val l = "xpto".toList()
    val a = l.toTypedArray()
    a[2] = 'y'
    a.forEach { print(it) }
    println(a.toList())
}