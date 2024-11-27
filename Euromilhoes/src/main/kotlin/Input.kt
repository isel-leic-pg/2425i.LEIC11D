

fun readInts(quest: String): List<Int> {
    print("$quest? ")
    //return readln().split(' ').map{ it.toIntOrNull() }.filter{ it!=null }
    return readln().split(' ').mapNotNull { it.toIntOrNull() }
}

fun readBet() = Bet(readInts("Numbers"), readInts("Stars"))

fun readValidBet(): Bet {
    while (true) {
        val bet = readBet()
        if (bet.isValid()) return bet
        println("Invalid bet: $bet")
    }
}
/*
tailrec fun readValidBet(): Bet {
    val bet = readBet()
    return if (bet.isValid()) bet
    else {
        println("Invalid bet: $bet")
        readValidBet()
    }
}
*/


/*
    var bet: Bet? = null
    do {
        if (bet!=null)
            println("Invalid bet: $bet")
        bet = readBet()
    } while (bet==null || !bet.isValid())
    return bet
*/