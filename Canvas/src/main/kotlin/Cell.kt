import pt.isel.canvas.*

data class Cell(val line: Int, val col: Int)

/*fun Cell.copy(line: Int = this.line, col: Int = this.col): Cell =
    Cell(line,col)
*/

fun Cell.move(key: KeyEvent): Cell =
    when (key.code) {
        RIGHT_CODE -> copy(col=col+1)  //Cell(line, col+1)
        LEFT_CODE -> copy(col=col-1)   //Cell(line, col-1)
        UP_CODE -> copy(line=line-1)   //Cell(line-1, col)
        DOWN_CODE -> copy(line=line+1) //Cell(line+1, col)
        ESCAPE_CODE -> Cell(LINES/2, COLUMNS/2)
        else -> this
    }