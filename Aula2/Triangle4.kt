/* Triangle.kt
    Escreva um programa que classifica um triângulo dado o comprimento de cada lado.
    O programa deve executar as seguintes ações:
    1. Questionar o utilizador sobre o lado A, B e C (Valor Inteiro)
    2. Apresentar uma das quatro possíveis classificações do triângulo no formato:
           O triângulo é <Impossível|Equilátero|Isósceles|Escaleno>
    3. Caso o triângulo seja retângulo apresentar também:
           O triângulo é retângulo
 */
 
fun readSide(name: Char): Int {
	print("Lado ${name}? ")
	val side = readln().trim().toInt()
	return side
}

fun max(x: Int, y: Int, z: Int): Int {
	if (x>y && x>z) return x
	return if(y>z) y else z
}

fun min(a: Int, b: Int, c: Int): Int {
    return when {
	   a<b && a<c -> a
	   b<c -> b
	   else -> c
	}
}

fun main() {
    val a = readSide('A')
	val b = readSide('B')
	val c = readSide('C')
	
	val type = when {
	  a<=0 || b<=0 || c<=0 || a+b<=c || a+c<=b || b+c<=a -> "Impossível"
      a==b && b==c                                       -> "Equilátero"
	  a==b || b==c || a==c                               -> "Isósceles"
	  else                                               -> "Escaleno"
	}
	println("O triângulo é $type")
	
	if (type=="Escaleno" || type=="Isósceles") {
		val h = max(a,b,c)
		val l1 = min(a,c,b)
		val l2 = a+b+c -h -l1
		if (h*h == l1*l1 + l2*l2) println("O triângulo é Retângulo")
	}
}