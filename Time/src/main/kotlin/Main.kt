
fun Int.toTime() = Time(this/3600, this%3600/60, this%3600%60)

fun main() {
    println("Tempo em horas, minutos e segundos")
    val t: Time = readTime()
    if ( t.isValid()  ) {
        val totalSeconds = t.toSeconds()
        println("Total em segundos = $totalSeconds")
        println(totalSeconds.toTime())
    } else
        println("Tempo inválido $t")
}

fun Time.isValid() = h in 0..<24 && m in 0..<60 && s in 0..<60

fun Time.toSeconds() = h * 3600 + m * 60 + s

