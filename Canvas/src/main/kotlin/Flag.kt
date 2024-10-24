import pt.isel.canvas.*

const val WIDTH = 850           // Total width of the flag
const val HEIGHT = 500          // Total height of the flag
const val GREEN_WIDTH = 300     // Width of the green part
const val RADIUS = 100          // Radius of the sphere
const val OFFSET = 50           // Offset of the coat of arms

fun main() {
    onStart {
        val area = Canvas(WIDTH,HEIGHT,RED)
        area.drawRect(0,0,GREEN_WIDTH,HEIGHT,GREEN)
        area.drawImage("esfera_armilar.png",
            GREEN_WIDTH-RADIUS, HEIGHT/2-RADIUS,
            RADIUS*2,RADIUS*2
        )
        area.drawImage("brasão.png",
            GREEN_WIDTH-RADIUS+OFFSET, HEIGHT/2-RADIUS+OFFSET,
            (RADIUS*2*0.5).toInt(), (RADIUS*2*0.6).toInt()
        )
        area.onMouseDown { me ->
            println("Click: ${me.x},${me.y}")
        }
    }
    onFinish {  }
}