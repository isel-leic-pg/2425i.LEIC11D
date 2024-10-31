import pt.isel.canvas.*

private const val WIDTH = 850           // Total width of the flag
private const val HEIGHT = 500          // Total height of the flag
private const val GREEN_WIDTH = 300     // Width of the green part
private const val RADIUS = 100          // Radius of the sphere
private const val OFFSET = 50           // Offset of the coat of arms

fun Canvas.drawSphere(x: Int, y: Int, radius: Int) {
    val size = radius*2
    this.drawImage("esfera_armilar",x-radius,y-radius,size,size)
}

fun main() {
    onStart {
        val area = Canvas(WIDTH,HEIGHT,RED)
        area.drawRect(0,0,GREEN_WIDTH,HEIGHT,GREEN)
        area.drawSphere(GREEN_WIDTH,HEIGHT/2,RADIUS)
        area.drawImage("brasão.png",
            GREEN_WIDTH-RADIUS+OFFSET, HEIGHT/2-RADIUS+OFFSET,
            (RADIUS*2*0.5).toInt(), (RADIUS*2*0.6).toInt()
        )
        area.onMouseDown { me ->
            area.drawSphere(me.x,me.y,RADIUS/4)
        }
    }
    onFinish {  }
}