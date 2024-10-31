import pt.isel.canvas.*

private const val FRAMES_RATE = 1000/40
private const val AREA_WIDTH = 600
private const val BALL_RADIUS = 50
private const val AREA_HEIGHT = 400
private const val MAX_SPEED = 5
private val SPEED_RANGE = -MAX_SPEED .. MAX_SPEED

data class Point(val x: Int, val y: Int)
data class Direction(val dx: Int, val dy: Int)
data class Ball(val center: Point, val dir: Direction)

fun randomDirection(): Direction =
    Direction( SPEED_RANGE.random(), SPEED_RANGE.random())

fun startBall(): Ball = Ball(
    center = Point( x= AREA_WIDTH/2, y= AREA_HEIGHT/2),
    dir = randomDirection()
)

fun Ball.move(): Ball {
    val x = center.x + dir.dx
    val y = center.y + dir.dy
    val dx = when {
        dir.dx > 0 && x+BALL_RADIUS >= AREA_WIDTH -> -dir.dx
        dir.dx < 0 && x-BALL_RADIUS <= 0 -> -dir.dx
        else -> dir.dx
    }
    val dy = when {
        dir.dy > 0 && y+BALL_RADIUS >= AREA_HEIGHT -> -dir.dy
        dir.dy < 0 && y-BALL_RADIUS <= 0 -> -dir.dy
        else -> dir.dy
    }
    return Ball( center = Point(x,y), dir = Direction(dx,dy))
}

fun main() {
    var balls: List<Ball> = listOf(startBall())
    onStart {
        val cv = Canvas(AREA_WIDTH, AREA_HEIGHT, BLACK)
        cv.onTimeProgress(FRAMES_RATE) {
            cv.erase()
            balls.forEach {  cv.drawBall(it) }
            balls = balls.map{ it.move() }
        }
        cv.onKeyPressed { key ->
            if (key.char==' ') balls = balls + startBall()
        }
    }
    onFinish {  }
}

private fun Canvas.drawBall(b: Ball) {
    drawCircle( b.center.x, b.center.y , BALL_RADIUS, YELLOW)
}