/*  TwoValues.kt
    Complete o programa que apresenta o resultado de várias operações
    entre dois valores inteiros positivos (A e B) introduzidos pelo utilizador.
    O programa deve executar as seguintes ações:
     1. Questionar o utilizador sobre o valor inteiro de A e depois ler o seu valor
     2. Questionar o utilizador sobre o valor inteiro de B e depois ler o seu valor
     3. Apresentar true se A < B e false se A >= B no formato: A < B == true/false
     4. Apresentar o valor que resulta para quatro operações aritméticas (+,-,x,/) no formato A <op> B == <result>
     O resultado da divisão é um valor real, mas os restantes são valores inteiros.
     Exemplo de utilização:
      A? 27
      B? 42
      *** A < B == true
	  A < B  / A >= B
      A + B == 69
      A – B == -15
      A x B == 1134
      A / B == 0.64285713
 */
fun main() {
    print("A? ")
    val a = readln().toInt()
    print("B? ")
    val b = readln().toInt()

	//println("$a < $b == ${a < b}")
	val oper = when {
	   a < b -> "<"
	   a > b -> ">"
	   a == b -> "=="
	}
	println("$a $oper $b")
	val op = if (a < b) "<" else ">="
	println("$a $op $b")

    println("$a + $b == ${a + b}")
    println("$a - $b == ${a - b}")
    println("$a x $b == ${a * b}")
	val div = a.toDouble() / b
    println("$a / $b == $div")
}