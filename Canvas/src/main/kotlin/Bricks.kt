import pt.isel.canvas.*

val ALL_CELLS: List<Cell> = List(LINES*COLUMNS) { Cell(it/COLUMNS, it%COLUMNS) }

fun Canvas.drawBrick(cell: Cell) {
    drawImage("bricks",cell.col*CELL_SIZE, cell.line*CELL_SIZE, CELL_SIZE, CELL_SIZE)
}

fun main() {
    var wall = ALL_CELLS
    onStart {
        val cv = Canvas(CELL_SIZE*COLUMNS, CELL_SIZE*LINES, BLACK)
        wall.forEach { cv.drawBrick(it) }
        cv.onKeyPressed {
            if (wall.isNotEmpty()) {
                val cell = wall.random()
                cv.eraseCell(cell)
                wall = wall - cell
            }
        }
        cv.onTimeProgress(1000) {
            val empties = ALL_CELLS - wall
            if (empties.isNotEmpty()) {
                val cell = empties.random()
                cv.drawBrick(cell)
                wall = wall + cell
            }
        }
    }
    onFinish {  }
}