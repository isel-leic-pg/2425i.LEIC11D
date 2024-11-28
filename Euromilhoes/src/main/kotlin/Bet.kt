const val MIN_NUMBERS = 5
const val MAX_NUMBERS = 11
const val MAX_NUMBER = 50

const val MIN_STARS = 2
const val MAX_STARS = 12
const val MAX_STAR = 12

data class Bet(
    val numbers: List<Int>, // 5 elements in 1..50
    val stars: List<Int>,   // 2 elements in 1..12
)

fun Bet.isValid(): Boolean =
    numbers.size in MIN_NUMBERS..MAX_NUMBERS &&
    stars.size in MIN_STARS..MAX_STARS &&
    numbers.all{ it in 1..MAX_NUMBER } &&
    stars.all{ it in 1..MAX_STAR } &&
    numbers.noRepeat() && stars.noRepeat()

fun randomBet() = Bet(
    numbers = (1..MAX_NUMBER).shuffled().take(MIN_NUMBERS).sorted(),
    stars = (1..MAX_STAR).shuffled().take(MIN_STARS).sorted()
)

fun PrizeOrder.printPrize(rep: Int, bet: Bet) {
    println("${rep+1} - $bet: ${n}º Prémio")
}

fun main() {  // 40 25 31 11 7 + 12 9
    val key = Bet(listOf(40,25,31,11,7), listOf(12,9) )
    println("key = $key")
    repeat(100) { n ->
        val bet = randomBet()
        val prize = key.prize(bet)
        prize?.printPrize(n,bet)
        //if (prize!=null) println(prize)
        prize?.let{ println(it) }
    }
    /*
    val bet = randomBet()
    println("bet = $bet")
    val prize: Prize? = key.prize(bet)
    println(prize)
    */

}