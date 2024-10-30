import pt.isel.canvas.*

const val FRAMES_RATE = 1000/40
const val AREA_WIDTH = 600
const val BALL_RADIUS = 50

fun main() {
    var x = AREA_WIDTH/2
    var dx = 5
    onStart {
        val cv = Canvas(AREA_WIDTH,400, BLACK)
        cv.onTimeProgress(FRAMES_RATE) {
            cv.erase()
            cv.drawCircle(x,cv.height/2,BALL_RADIUS, YELLOW)
            x+=dx
            if (x > cv.width-BALL_RADIUS) dx = -5
            else if ( x < 0+BALL_RADIUS) dx = +5
        }
    }
    onFinish {  }
}