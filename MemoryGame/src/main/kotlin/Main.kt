const val SYMBOLS = "#%X"  // SYMBOLS.length <= 5
const val SIZE_PAIRS = SYMBOLS.length * 2


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
