
fun readCharR(name: String, range: CharRange = 'A'..'Z'): Char {
    print("Símbolo $name ($range)? ")
    val sym = readln().trim()[0]
    if (sym in range) return sym
    return readCharR(name,range)
}

fun main() {
    val start = readCharR("inicial")
    val end = readCharR("final", start..'Z')

    for(c in start..end)
        println("$c - ${c.code}")
}