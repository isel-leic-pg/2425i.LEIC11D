/* Triangle.kt
    Escreva um programa que classifica um triângulo dado o comprimento de cada lado.
    O programa deve executar as seguintes ações:
    1. Questionar o utilizador sobre o lado A, B e C (Valor Inteiro)
    2. Apresentar uma das quatro possíveis classificações do triângulo no formato:
           O triângulo é <Impossível|Equilátero|Isósceles|Escaleno>
    3. Caso o triângulo seja retângulo apresentar também:
           O triângulo é retângulo
 */

fun main() {
    print("Lado A? ")
    val a = readln().trim().toInt()
    print("Lado B? ")
    val b = readln().trim().toInt()
    print("Lado C? ")
    val c = readln().trim().toInt()
	
	when {
	  a<=0 || b<=0 || c<=0 || a+b<=c || a+c<=b || b+c<=a ->
	     println("O triângulo é Impossível")
      a==b && b==c ->
	     println("O triângulo é Equilátero")
	  a==b || b==c || a==c ->
	     println("O triângulo é Isósceles")
	  else ->
	     println("O triângulo é Escaleno")
	}
	val a2 = a*a
	val b2 = b*b
	val c2 = c*c
	if (a2 == b2 + c2 || b2 == a2 + c2 || c2 == b2 + a2)
	   println("O triângulo é Retângulo")
	
}