
/*
fun String.split(separator: Char): List<String> {
    var res: List<String> = emptyList()
    var word = ""
    for(c in this) {
        if (c!=separator) word += c
        else {
            res = res + word
            word = ""
        }
    }
    return res + word
}
*/

/*
fun List<Int>.all( condition: (Int)->Boolean ): Boolean {
    for(n in this)
       if ( !condition(n) ) return false
    return true
}*/

/*
fun List<Int>.distinct(): List<Int> {
    var res = emptyList<Int>()
    for (n in this)
        if (n !in res) res = res + n
    return res
}
*/

fun List<Int>.noRepeat(): Boolean = distinct().size == size
/*{
    for(i in 0..size-2) {
        for(j in i+1..<size)
            if (this[i]==this[j]) return false
    }
    return true
}*/
