package raytracer

import kotlin.math.sqrt

data class Tuple(val x: Float, val y: Float, val z: Float, val w: Float) {
    fun getType(): TupleType {
        return when (w) {
            1.0f -> TupleType.POINT
            0.0f -> TupleType.VECTOR
            else -> TupleType.TUPLE
        }
    }

    operator fun plus(a: Tuple): Tuple {
        return tuple(this.x + a.x, this.y + a.y, this.z + a.z, this.w + a.w)
    }

    operator fun minus(a: Tuple): Tuple {
        return tuple(this.x - a.x, this.y - a.y, this.z - a.z, this.w - a.w)
    }

    operator fun unaryMinus(): Tuple {
        return tuple(-this.x, -this.y, -this.z, -this.w)
    }

    operator fun times(multiplier: Float): Tuple {
        return tuple(
                this.x * multiplier,
                this.y * multiplier,
                this.z * multiplier,
                this.w * multiplier
        )
    }

    operator fun div(divider: Float): Tuple {
        return tuple(
                this.x / divider,
                this.y / divider,
                this.z / divider,
                this.w / divider
        )
    }
}

fun tuple(x: Float, y: Float, z: Float, w: Float): Tuple {
    return Tuple(x, y, z, w)
}

fun point(x: Float, y: Float, z: Float): Tuple {
    return tuple(x, y, z, 1.0f)
}

fun vector(x: Float, y: Float, z: Float): Tuple {
    return tuple(x, y, z, 0.0f)
}

fun color(x: Float, y: Float, z: Float): Tuple {
    return tuple(x, y, z, -99f)
}

// Think Pythagoras
fun magnitude(v: Tuple): Float {
    return sqrt(v.x*v.x + v.y*v.y + v.z*v.z + v.w*v.w)
}

fun normalize(v: Tuple): Tuple {
    val m = magnitude(v)
    return vector(v.x / m, v.y / m, v.z / m)
}

fun dot(a:Tuple, b: Tuple): Float {
    return  a.x * b.x +
            a.y * b.y +
            a.z * b.z +
            a.w * b.w;
}

fun cross(a: Tuple, b: Tuple): Tuple {
    return vector(  a.y * b.z - a.z * b.y,
                    a.z * b.x - a.x * b.z,
                    a.x * b.y - a.y * b.x)
}

enum class TupleType {
    COLOR, POINT, TUPLE, VECTOR
}