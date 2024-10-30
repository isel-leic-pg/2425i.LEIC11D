import pt.isel.canvas.*

const val LINES = 10
const val COLUMNS = 15
const val CELL_SIZE = 64

const val SPRITE_SIZE = 64

fun Canvas.drawSprite(sprite: Cell, cell: Cell) {
    drawImage(
        "snake|${sprite.col*SPRITE_SIZE},${sprite.line*SPRITE_SIZE},$SPRITE_SIZE,$SPRITE_SIZE",
        cell.col*CELL_SIZE, cell.line*CELL_SIZE, CELL_SIZE, CELL_SIZE
    )
}
fun Canvas.drawApple(cell: Cell) {
    drawSprite(Cell(3,0),cell)
}
fun Canvas.eraseCell(cell: Cell) {
    drawRect(cell.col*CELL_SIZE+1, cell.line*CELL_SIZE+1, CELL_SIZE-1, CELL_SIZE-1, background)
}
fun Canvas.drawGrid() {
    for(x in CELL_SIZE..<width step CELL_SIZE)
        drawLine(x,0,x,height, YELLOW,1)
    for(y in CELL_SIZE..<height step CELL_SIZE)
        drawLine(0,y,width,y, YELLOW,1)
//    for (l in 0..<LINES)
//        for (c in 0..<COLUMNS)
//            drawRect(c*CELL_SIZE,l*CELL_SIZE,CELL_SIZE,CELL_SIZE, YELLOW, 1)
}

fun main() {
    var cursor = Cell(LINES/2, COLUMNS/2)
    onStart {
        val cv = Canvas(CELL_SIZE*COLUMNS, CELL_SIZE*LINES, BLACK)
        cv.drawGrid()
        cv.drawApple(cursor)
        cv.onKeyPressed { key ->
            if (key.char==' ') cv.close()
            cv.eraseCell(cursor)
            cursor = cursor.move(key)
            cv.drawApple(cursor)
        }
    }
    onFinish {  }
}