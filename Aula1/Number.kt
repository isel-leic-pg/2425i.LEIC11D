/* Number.kt
   Complete o programa para ler um número inteiro e imprimir:
   - O dobro do número: nnnn * 2 = dobro
   - Se é ou não par: nnnn é par = true/false
   - O número de digitos: nnnn tem DD dígitos
   - A soma do dígito de maior peso com o de menor peso: D1 + D2 = soma
   Exemplo:
      4578
	  4578 * 2 = ?????
	  4578 é par = true
	  4578 tem 4 dígitos
	  4 + 8 = 12
 */
fun main() {
    print("Número inteiro? ")
    val str = readln().trim()
	val n = str.toInt()
	val len = str.length
	println("$n * 2 = ${n * 2}")
	val even = n % 2 == 0
    println("$n é par = $even")
	println("$n tem $len dígitos")
    val d1 = str[0] - '0'
	val d2 = n % 10
	println("$d1 + $d2 = ${d1 + d2}")
}