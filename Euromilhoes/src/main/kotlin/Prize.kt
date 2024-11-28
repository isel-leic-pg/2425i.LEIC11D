
/*
enum class Prize(val numbers: Int, val stars: Int) {
    PRIZE_1(5,2), PRIZE_2(5,1), PRIZE_3(5,0),
    PRIZE_4(4,2), PRIZE_5(4,1), PRIZE_6(3,2),
    PRIZE_7(4,0), PRIZE_8(2,2), PRIZE_9(3,1),
    PRIZE_10(3,0), PRIZE_11(1,2), PRIZE_12(2,1),
    PRIZE_13(2,0)
}
*/

data class Prize(val numbers: Int, val stars: Int)

val prizes = listOf(
    Prize(5,2), Prize(5,1), Prize(5,0),
    Prize(4,2), Prize(4,1), Prize(3,2),
    Prize(4,0), Prize(2,2), Prize(3,1),
    Prize(3,0), Prize(1,2), Prize(2,1),
    Prize(2,0)
)

fun List<Int>.countEquals(l: List<Int>): Int = l.count { it in this }
/*
    var count = 0
    forEach {
        if (it in l) count++
    }
    return count
*/

data class PrizeOrder(val n: Int, val prize: Prize)

fun Bet.prize(bet: Bet): PrizeOrder? {
    val equalNumbers = numbers.countEquals(bet.numbers)
    val equalStars = stars.countEquals(bet.stars)
    prizes.forEachIndexed { idx, p ->
        if (p.numbers==equalNumbers && p.stars==equalStars)
            return PrizeOrder(idx+1,p)
    }
/*
    for (idx in prizes.indices) {
        val p = prizes[idx]
        if (p.numbers==equalNumbers && p.stars==equalStars)
            return PrizeOrder(idx+1,p)
    }
*/
    return null
/*
    return prizes.firstOrNull{
        it.numbers==equalNumbers && it.stars==equalStars
    }
*/
}
