package exercises

import raytracer.Tuple4
import raytracer.point
import raytracer.vector
import java.util.*

data class Projectile (val position: Tuple4, val velocity: Tuple4)

data  class Environment (val gravity: Tuple4, val wind: Tuple4)

fun tick (e: Environment, p: Projectile): Projectile {
    val position = p.position + p.velocity
    val velocity = p.velocity + e.gravity + e.wind

    return Projectile(position, velocity)
}

fun main(args: Array<String>) {
    var p = Projectile(point(0f, 1f, 0f), vector(12f, 8f, 0f).normalize())
    val e = Environment(vector(0f, -0.1f, 0f), vector(-0.01f, 0f, 0f))

    var i = 0
    while (p.position.y > 0) {
        val log = "$i; ${p.position.x}; ${p.position.y}"
        println(log.replace('.', ','))
        p = tick(e, p)
        i++
    }
}