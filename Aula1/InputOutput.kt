/*
    Faça um programa que leia valores de diferentes tipos e apresente com algumas alterações:
    - Inteiro e o seu sucessor
    - Real e o seu quadrado
    - Caracter e o seu código Unicode
    - String e o seu tamanho
    Exemplo de utilização:
        Inteiro? 42
        42 + 1 = 43
        Real? 3.14
        3.14^2 = 9.8596
        Caracter? A
        A = 65
        String? ISEL
        ISEL tem 4 caracteres
*/
fun main() {
	print("Inteiro? ")
	val n = readln().trim().toInt()
	println("$n + 1 = ${n + 1}")
	
	print("Real? ")
	val r: Float = readln().toFloat()
	println("${r}^2 = ${r * r}")
	
	print("Caráter? ")
	val c = readln()[0]
	println("$c = ${c.code}")
	
    print("String? ")
    val s = readln().trim()
	println("$s tem ${s.length} caracteres")
}
