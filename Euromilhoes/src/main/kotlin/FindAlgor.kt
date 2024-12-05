
/*
Pesquisa sequencial.
Coleção não tem que estar ordenada.
 */
fun List<Char>.idxOf(c: Char): Int? {
    for(idx in indices)
        if (get(idx) == c)
            return idx
    return null
}

/*
Pesquisa binária/dicotómica não recursiva.
Coleção tem que estar ordenada.
 */
fun List<Char>.idxOfBinNR(c: Char): Int? {
    var from = 0
    var to = size-1
    while (from <= to) {
        val mid = (to+from)/2
        if (c == get(mid))
            return mid
        if (c < get(mid))
            to = mid-1
        else
            from = mid+1
    }
    return null
}

/*
Pesquisa binária/dicotómica recursiva.
Coleção tem que estar ordenada.
 */
fun List<Char>.idxOfBin(c: Char, from: Int =0, to: Int= size-1): Int? {
    if (from>to) return null
    val mid = (to+from)/2
    if (c == get(mid))
        return mid
    return if (c < get(mid)) idxOfBin(c,from,mid-1)
           else idxOfBin(c,mid+1,to)
}

fun main() {
    val l = listOf('a','b','c','d')
    println( l.idxOf('c') )
    val ls = List(32) { ('A'..'Z').random() }.sorted()
    println(ls)
    println( ls.idxOfBin('S') )
}