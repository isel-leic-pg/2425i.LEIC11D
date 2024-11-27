

enum class Prize(val numbers: Int, val stars: Int) {
    PRIZE_1(5,2), PRIZE_2(5,1), PRIZE_3(5,0),
    PRIZE_4(4,2), PRIZE_5(4,1), PRIZE_6(3,2),
    PRIZE_7(4,0), PRIZE_8(2,2), PRIZE_9(3,1),
    PRIZE_10(3,0), PRIZE_11(1,2), PRIZE_12(2,1),
    PRIZE_13(2,0)
}

fun List<Int>.countEquals(l: List<Int>): Int = l.count { it in this }
/*
    var count = 0
    forEach {
        if (it in l) count++
    }
    return count
*/

fun Bet.prize(bet: Bet): Prize? {
    val equalNumbers = numbers.countEquals(bet.numbers)
    val equalStars = stars.countEquals(bet.stars)
    return Prize.entries.firstOrNull{
        it.numbers==equalNumbers && it.stars==equalStars
    }
}
