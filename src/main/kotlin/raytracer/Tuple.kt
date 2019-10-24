package raytracer

data class Tuple(val x: Double, val y: Double, val z: Double, val w: Double)

fun point(x: Double, y: Double, z: Double): Tuple {
    return Tuple(x, y, z, 1.0)
}

fun vector(x: Double, y: Double, z: Double): Tuple {
    return Tuple(x, y, z, 0.0)
}
