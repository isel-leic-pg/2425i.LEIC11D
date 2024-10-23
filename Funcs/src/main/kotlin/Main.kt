
fun double(a: Int): Int = 2 * a

fun invert(a: Int): Int = -a

fun printOper(v: Int, f: (Int)->Int) {
    println( f(v) )
}

fun main() {   // ()->Unit
    println(double(invert(2))) // -> -4
    var fx: (Int)->Int = ::invert
    println(fx(2)) // -> -2
    fx = ::double
    println(fx(2)) // -> 4

    printOper(4,::invert)  // -> -4
    printOper(4,fx)        // -> 8
    printOper(2,{ a -> invert(a*3) }) // -> -6
    printOper(2) { a -> invert(a*3) } // -> -6
    fx = {
        val x = it*it
        2*x
    }
    printOper(3,fx)  // -> 18
    val otherFx = { a:Int, b:Int -> a*b }

    repeat(4) {
        print(it)
    }   // -> 0123
    println()
    for(i in 0..3) {
        print(i)
    }   // -> 0123


    val s = readln()   // readln: ()->String
    println(s)
}

