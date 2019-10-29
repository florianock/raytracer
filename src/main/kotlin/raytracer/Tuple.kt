package raytracer

// factory methods
// points & vectors
fun tuple(x: Float, y: Float, z: Float, w: Float): Tuple4 {
    return Tuple4(x, y, z, w)
}

fun point(x: Float, y: Float, z: Float): Tuple4 {
    return tuple(x, y, z, 1.0f)
}

fun vector(x: Float, y: Float, z: Float): Tuple4 {
    return tuple(x, y, z, 0.0f)
}

// colors
fun tuple(x: Float, y: Float, z: Float): Tuple3 {
    return Tuple3(x, y, z)
}

fun color(x: Float, y: Float, z: Float): Tuple3 {
    return tuple(x, y, z)
}
