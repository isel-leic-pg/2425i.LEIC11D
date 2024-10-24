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
    var count = 0
    for (c in pairs) {
        if (c == sym) count++
    }
    return count
}

fun readPlay(pairs: String): Play = readPlay(pairs) {
    it in '0'..'9' && it.digitToInt() in 0 ..< SIZE_PAIRS
}

fun readPlay(pairs: String, validator: (Char)->Boolean): Play {
    while (true) {
        print("$pairs -> ")
        val line = readln().trim()
        if (line.length==2 && validator(line[0]) && validator(line[1]))
            return Play(line[0].digitToInt(), line[1]-'0')
    }
}


/**
 * Returns the showed string with the pair showed.
 * @param secret: the secret pairs
 * @param showed: the showed pairs
 * @param first: the first index to show
 * @param second: the second index to show
 * @return the showed pairs with the pair showed
 */
fun showPair(
    secret: String,
    showed: String,
    first: Int,
    second: Int
): String {
    var res = ""
    for(i in secret.indices)
        res +=
            if (i==first || i==second) secret[i]
            else showed[i]
    return res
}
