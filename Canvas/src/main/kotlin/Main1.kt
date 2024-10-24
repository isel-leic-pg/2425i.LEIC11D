import pt.isel.canvas.*

fun main() {
    println("Begin")
    onStart {
        val cv = Canvas(800,600, GREEN)
        println("Start")
        cv.drawCircle(400,300,100, MAGENTA, 5)
        cv.drawLine(0,0,800,600,RED,20)
        cv.drawArc(400,300,50, 0, 90, WHITE)
        cv.drawText(10,300,"g ISEL",RED,64)
        cv.drawLine(10,300,200,300, BLACK)
        cv.drawImage("brasão.png",0,0,100,120)
        val cv2 = Canvas(50,50, BLUE)
        cv2.drawRect(10,10,30,30, BLACK,5)
    }
    onFinish {
        println("Bye")
    }
    println("End")
}