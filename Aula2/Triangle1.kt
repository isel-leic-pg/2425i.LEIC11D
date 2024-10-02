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
    if ( a<=0 || b<=0 || c<=0 || a+b<=c || a+c<=b || b+c<=a )
	   println("O triângulo é Impossível")
    else if ( a==b && b==c )
	   println("O triângulo é Equilátero")
	else if ( a==b || b==c || a==c )
	   println("O triângulo é Isósceles")
	else
	   println("O triângulo é Escaleno")
	
	if (a*a == b*b + c*c || b*b == a*a + c*c || c*c == b*b + a*a)
	   println("O triângulo é Retângulo")
	
}