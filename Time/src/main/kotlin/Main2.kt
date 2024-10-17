
data class Time(val h: Int, val m: Int, val s: Int)

fun readTime(): Time {
    val hours = readInt("Horas")
    val minutes = readInt("Minutos")
    val seconds = readInt("Segundos")
    return Time(hours,minutes,seconds)
}

fun isValidTime(tm: Time) = tm.h in 0..<24 && tm.m in 0..<60 && tm.s in 0..<60

fun timeToSeconds(tm: Time) = tm.h * 3600 + tm.m * 60 + tm.s

fun main() {
    println("Tempo em horas, minutos e segundos")
    val t: Time = readTime()
    if ( isValidTime(t)  ) {
        val totalSeconds = timeToSeconds(t)
        println("Total em segundos = $totalSeconds")
    } else
        println("Tempo inválido (${t.h},${t.m},${t.s})")
}

