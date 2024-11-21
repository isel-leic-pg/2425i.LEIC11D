import pt.isel.canvas.*

data class Offset(val dRow: Int, val dCol: Int)

enum class Dir(val offset: Offset, val key: Int) {
    UP   (Offset(-1,0), UP_CODE),
    RIGHT(Offset(0,+1), RIGHT_CODE),
    DOWN (Offset(+1,0), DOWN_CODE),
    LEFT (Offset(0,-1), LEFT_CODE)
}

fun Dir.toOffset(): Offset = offset
/*
    when(this) {
        Dir.UP -> Offset(-1,0)
        Dir.RIGHT -> Offset(0,+1)
        Dir.DOWN -> Offset(+1,0)
        Dir.LEFT -> Offset(0,-1)
    }
*/

fun Int.keyToDir(): Dir? =
    Dir.entries.firstOrNull { it.key == this }
/*
    for(d in Dir.entries)
        if (this == d.key) return d
    return null
*/
/*
    return when(this) {
        LEFT_CODE -> Dir.LEFT
        RIGHT_CODE -> Dir.RIGHT
        UP_CODE -> Dir.UP
        DOWN_CODE -> Dir.DOWN
        else -> null
    }
*/

fun enumTests() {
    val d: Dir = Dir.LEFT
    println(d==Dir.LEFT)
    println(d.name)
    println(d.ordinal)
    println(d > Dir.UP)
    println(Dir.entries)
    for (dir in Dir.entries) {
        println("$dir: ${dir.ordinal} ${dir.toOffset()} ")
    }
    val keyCode = 27//LEFT_CODE
    val dirKey: Dir? = keyCode.keyToDir()
    if (dirKey != null) println(dirKey.toOffset())

    println( d.next() )
    val str = readln()
    val i = str.toIntOrNull()
    if (i != null) println(i)
}

fun Dir.next(): Dir =
    Dir.entries[ (ordinal+1) % Dir.entries.size ]
//    if (ordinal<Dir.entries.size) Dir.entries[ ordinal+1 ]
//    else Dir.entries[0]

fun main() {
    onStart {
        val cv = Canvas(600,600, BLACK)
        cv.onKeyPressed { key ->
            val dir = key.code.keyToDir()
            println(dir)
        }
    }
    onFinish {  }
}