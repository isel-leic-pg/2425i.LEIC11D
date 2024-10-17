fun main() {
    println("Tempo em horas, minutos e segundos")
    val hours = readInt("Horas")
    val minutes = readInt("Minutos")
    val seconds = readInt("Segundos")
    if ( isValidTime(hours,minutes,seconds)  ) {
        val totalSeconds = timeToSeconds(hours,minutes,seconds)
        println("Total em segundos = $totalSeconds")
    } else
        println("Tempo inválido ($hours,$minutes,$seconds)")
}

fun readInt(quest: String): Int {
    print("$quest ? ")
    return readln().trim().toInt()
}

fun isValidTime(h: Int, m: Int, s: Int) =
    h in 0..<24 && m in 0..<60 && s in 0..<60

fun timeToSeconds(h: Int, m: Int, s: Int) = h * 3600 + m * 60 + s
