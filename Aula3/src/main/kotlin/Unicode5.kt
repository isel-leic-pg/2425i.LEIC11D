
fun readSymbol(name: String, range: CharRange = 'A'..'Z'): Char {
    var sym: Char
    do {
        print("Símbolo $name ($range)? ")
        sym = readln().trim()[0]
    } while (sym !in range)
    return sym
}

fun main() {
    val start = readSymbol("inicial")
    val end = readSymbol("final", start..'Z')

    for(c in start..end)
        println("$c - ${c.code}")
}