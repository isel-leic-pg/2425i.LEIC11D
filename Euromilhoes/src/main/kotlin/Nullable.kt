
fun readName(): String? {
    val line = readln().trim()
    return if (line.all { it.isLetterOrDigit() }) line else null
}

fun main() {
    val name = readName()
    println(name ?: "")
    println(name?.length ?: 1)
    val x: Int? = name?.toIntOrNull()
    println(x)
}