import pt.isel.canvas.*
import kotlin.math.*

private const val FRAMES_RATE = 1000/40
private const val AREA_WIDTH = 800
private val BALL_RADIUS_RANGE = 20..60
private const val AREA_HEIGHT = 600
private const val MAX_SPEED = 10
private val SPEED_RANGE = -MAX_SPEED .. MAX_SPEED

data class Point(val x: Int, val y: Int)
data class Direction(val dx: Int, val dy: Int)

data class Ball(val center: Point, val dir: Direction, val color: Int, val radius: Int)

fun randomDirection(): Direction =
    Direction( SPEED_RANGE.random(), SPEED_RANGE.random())

fun startBall(): Ball = Ball(
    center = Point( x= AREA_WIDTH/2, y= AREA_HEIGHT/2),
    dir = randomDirection(),
    color = (0x0000FF..0x00FFFFFF).random(),
    radius = BALL_RADIUS_RANGE.random()
)

operator fun Point.plus(dir: Direction) = Point(x+dir.dx, y+dir.dy)

operator fun Point.plus(p: Point) = Point(x+p.x, y+p.y)

fun Ball.move(): Ball {
    val c = center + dir
    val dx = when {
        dir.dx > 0 && c.x+radius >= AREA_WIDTH -> -dir.dx
        dir.dx < 0 && c.x-radius <= 0 -> -dir.dx
        else -> dir.dx
    }
    val dy = when {
        dir.dy > 0 && c.y+radius >= AREA_HEIGHT -> -dir.dy
        dir.dy < 0 && c.y-radius <= 0 -> -dir.dy
        else -> dir.dy
    }
    return copy(
        center = c,
        dir = if(dx!=dir.dx || dy!=dir.dy) Direction(dx,dy) else dir
    )
}

fun Point.distanceTo(p: Point): Int {
    val dx = p.x - x
    val dy = p.y - y
    return sqrt((dx*dx + dy*dy).toFloat()).toInt()
}

operator fun Ball.contains(pt: Point): Boolean = center.distanceTo(pt) <= radius

fun main() {
    var balls: List<Ball> = List(1) { startBall() }
    onStart {
        val cv = Canvas(AREA_WIDTH, AREA_HEIGHT, BLACK)
        cv.onTimeProgress(FRAMES_RATE) { time ->
            balls = balls.map { it.move() }
            cv.drawAll(balls, time/1000)
        }
        cv.onKeyPressed { key ->
            if (key.char==' ') balls = balls + startBall()
        }
        cv.onMouseDown { me ->
            val click = Point(me.x,me.y)
            balls = balls.filter { click !in it }
            if (balls.isEmpty())
                cv.onTime(3000) { cv.close() }
        }
    }
    onFinish {  }
}

fun Canvas.drawAll(balls: List<Ball>, seconds: Long) {
    erase()
    balls.forEach { drawBall(it) }
    drawText(0, AREA_HEIGHT, "Balls: ${balls.size}", WHITE, 32)
    drawText(AREA_WIDTH - 180, AREA_HEIGHT, "Time: $seconds", YELLOW, 32)
    if (balls.isEmpty())
        drawText(AREA_WIDTH / 2 - 250, AREA_HEIGHT / 2, "You win", YELLOW, 128)
}

fun Canvas.drawBall(b: Ball) {
    drawCircle( b.center.x, b.center.y, b.radius, b.color)
}