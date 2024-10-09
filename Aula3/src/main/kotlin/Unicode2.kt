fun main() {
    var c = 'A'
    do {
        println("$c - ${c.code}")
        c++ // c += 1 ; c = c + 1
    } while( c <= 'Z' )
}