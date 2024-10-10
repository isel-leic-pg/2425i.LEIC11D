const val SYMBOLS = "#%X"  // SYMBOLS.length <= 5
const val SIZE_PAIRS = SYMBOLS.length * 2

fun repeatedChars(n: Int, c: Char): String {
    var res = ""
    repeat(n) { res += c } // for(? in 0 ..< n) res+=c
    return res
}

fun stringOf(r: IntRange): String {
    var res = ""
    for(n in r) res += n
    return res
}

fun genSecretPairs(): String {
    var pairs = ""
    while (pairs.length < SIZE_PAIRS) {
        val sym = SYMBOLS.random()
        if (countSymbol(pairs,sym)<2)
            pairs += sym
    }
    return pairs
}

fun countSymbol(pairs: String, sym: Char): Int {
    return 0
}

fun readPlay(pairs: String): String {
    print("$pairs -> ")
    readln()
    return "01"
}

fun showPair(secret: String, showed: String, first: Int, second: Int): String {
    return showed
}

fun main() {
    val secret: String = genSecretPairs()
    println(stringOf(secret.indices))
    var showed: String = repeatedChars(SIZE_PAIRS, '_')
    while( showed!=secret ) {
        val play = readPlay(showed)
        val first = play[0] - '0'
        val second = play[1] - '0'
        val tmp: String = showPair(secret, showed, first, second)
        if (secret[first] == secret[second])
            showed = tmp
        else {
            print(tmp)
            Thread.sleep(2000)
            print("\r${repeatedChars(SIZE_PAIRS, ' ')}\r")
        }
    }
    println(secret)
}
