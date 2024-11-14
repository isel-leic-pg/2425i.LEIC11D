import pt.isel.canvas.*

data class Offset(val dRow: Int, val dCol: Int)

enum class Dir {
    UP, RIGHT, DOWN, LEFT
}

fun Dir.toOffset(): Offset =
    when(this) {
        Dir.UP -> Offset(-1,0)
        Dir.RIGHT -> Offset(0,+1)
        Dir.DOWN -> Offset(+1,0)
        Dir.LEFT -> Offset(0,-1)
    }

fun Int.keyToDir(): Dir? =
    when(this) {
        LEFT_CODE -> Dir.LEFT
        RIGHT_CODE -> Dir.RIGHT
        UP_CODE -> Dir.UP
        DOWN_CODE -> Dir.DOWN
        else -> null
    }

fun main() {
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
}

fun Dir.next(): Dir =
    Dir.entries[ (ordinal+1) % Dir.entries.size ]
//    if (ordinal<Dir.entries.size) Dir.entries[ ordinal+1 ]
//    else Dir.entries[0]