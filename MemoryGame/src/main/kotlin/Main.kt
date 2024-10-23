const val SYMBOLS = "#%X"  // SYMBOLS.length <= 5
const val SIZE_PAIRS = SYMBOLS.length * 2

/**
 * @property first: The first index to show
 * @property second: The second index to show
 */
data class Play(val first: Int, val second: Int)

fun main() {
    val secret: String = genSecretPairs()
    println(stringOf(secret.indices))
    var showed: String = repeatedChars(SIZE_PAIRS, '_')
    while( showed!=secret ) {
        val (idx1,idx2) = readPlay(showed)
        val tmp: String = showPair(secret, showed, idx1, idx2)
        if (secret[idx1] == secret[idx2])
            showed = tmp
        else {
            print(tmp)
            Thread.sleep(2000)
            print("\r${repeatedChars(SIZE_PAIRS, ' ')}\r")
        }
    }
    println(secret)
}
