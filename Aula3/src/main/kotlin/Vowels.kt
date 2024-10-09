/**
 * Conta as letras vogais da linha de texto introduzida.
 * Mas só conta as vogais até ao ponto final.
 */

fun countVowelsInText(s: String): Int {
    var count = 0
    for(c in s) when(c) {
        '.' -> break
        in "aeiouAEIOU" -> count++
    }
    return count
}

fun main() {
    print("Linha de texto? ")
    val txt = readln()
    val vowels = countVowelsInText(txt)
    println("O texto tem $vowels vogais.")
}