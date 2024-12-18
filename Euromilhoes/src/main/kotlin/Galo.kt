const val WIDTH = 3
const val DIM = WIDTH * WIDTH
const val USER = 'O'
const val COMPUTER = 'X'
const val EMPTY = ' '

var board = List(DIM) { EMPTY }

fun readInt(quest: String): Int? {
    print("$quest? ")
    return readln().toIntOrNull()
}

fun printBoard(board: List<Char>) {
    val sepLine = "---+".repeat(WIDTH-1)+"---"
    board.chunked(WIDTH)
        .map { it.joinToString(separator= " | ") }
        .forEachIndexed { i, line ->
            println(" $line ")
            if (i < WIDTH-1)
                println(sepLine)
        }
}

fun userMove(quest: String, error: String): Int {
    while (true) {
        val m = readInt(quest)
        if (m!=null && m in board.indices && board[m]==EMPTY)
            return m
        println(error)
    }
}

fun computerMove(): Int =
    board.indices.filter { board[it]==EMPTY }.random()

fun List<Char>.play(move: Int, symbol: Char): List<Char> =
    mapIndexed{ i, c -> if (i==move) symbol else c }

fun List<Char>.boardCompleted(): Boolean = all{ it!= EMPTY }

fun List<Char>.lineCompleted(symbol: Char): Boolean =
    indices.chunked(WIDTH)
        .any{ row -> row.all{ this[it]==symbol} } ||
    indices.sortedBy { it%WIDTH }.chunked(WIDTH)
        .any{ row -> row.all{ this[it]==symbol} } ||
    (0..<DIM step WIDTH+1).all { this[it]==symbol } ||
    (WIDTH-1..<DIM-1 step WIDTH-1).all { this[it]==symbol }

fun finish(player: Char): Boolean {
    printBoard(board)
    if (board.lineCompleted(player)) {
        println(
            if (player==USER) "Ganhou o utilizador"
            else "O utilizador perdeu"
        )
        return true
    }
    if (board.boardCompleted()) {
        println("Empatou")
        return true
    }
    return false
}

fun main() {
    printBoard(board)
    while (true) {
        val mu = userMove("Jogada do utilizador:","Jogada inválida")
        board = board.play(mu,USER)
        if (finish(USER)) break
        val mc = computerMove()
        println("Jogada do computador: $mc")
        board = board.play(mc,COMPUTER)
        if (finish(COMPUTER)) break
    }
}
