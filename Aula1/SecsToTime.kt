/*  SecsToTime.kt
 Escreva um programa que:
    1. Pergunte ao utilizador um tempo em segundos:
      - Escreve a pergunta "Indique o tempo em segundos: "
      - Lê o tempo em segundos introduzido pelo utilizador
    2. Imprima o tempo em horas, minutos e segundos:
      - Calcula o número de horas, minutos e segundos
      - Imprime no formato: "HH hora(s), MM minuto(s) e SS segundo(s)"
 */
 const val SECS_IN_HOUR = 3600
 const val SECS_IN_MINUTE = 60
 
 fun main() {
    print("Indique o tempo em segundos: ")
	val tm = readln().toInt()
	val h = tm / SECS_IN_HOUR
	val rem = tm % SECS_IN_HOUR
	val m = rem / SECS_IN_MINUTE
	val s = rem % SECS_IN_MINUTE
	println("$h hora(s), $m minuto(s) e $s segundo(s)")
 }
