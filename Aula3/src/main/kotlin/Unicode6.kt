
fun readChar(name: String, range: CharRange = 'A'..'Z'): Char {
    while (true) {
        print("Símbolo $name ($range)? ")
        val sym = readln().trim()[0]
        if (sym in range) return sym
    }
}

fun main() {
    val start = readChar("inicial")
    val end = readChar("final", start..'Z')

    for(c in start..end)
        println("$c - ${c.code}")
}