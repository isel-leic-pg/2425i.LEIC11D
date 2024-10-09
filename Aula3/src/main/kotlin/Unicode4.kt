fun main() {
    var start: Char
    do {
        print("Símbolo inicial? ")
        start = readln().trim()[0]
    } while (start !in 'A'..'Z')

    for(c in start..'Z')
        println("$c - ${c.code}")
}