package raytracer

data class Tuple(val x: Float, val y: Float, val z: Float, val w: Float) {
    fun getType(): TupleType {
        return when (w) {
            1.0f -> TupleType.POINT
            0.0f -> TupleType.VECTOR
            -99f -> TupleType.COLOR
            else -> TupleType.TUPLE
        }
    }
}

fun point(x: Float, y: Float, z: Float): Tuple {
    return Tuple(x, y, z, 1.0f)
}

fun vector(x: Float, y: Float, z: Float): Tuple {
    return Tuple(x, y, z, 0.0f)
}

fun color(x: Float, y: Float, z: Float): Tuple {
    return Tuple(x, y, z, -99f)
}

enum class TupleType {
    COLOR, POINT, TUPLE, VECTOR
}