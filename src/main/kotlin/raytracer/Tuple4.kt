package raytracer

import kotlin.math.sqrt

data class Tuple4(val x: Float, val y: Float, val z: Float, val w: Float) {

    fun getType(): TupleType {
        return when (w) {
            1.0f -> TupleType.POINT
            0.0f -> TupleType.VECTOR
            else -> TupleType.TUPLE
        }
    }

    operator fun plus(a: Tuple4): Tuple4 {
        return tuple(this.x + a.x, this.y + a.y, this.z + a.z, this.w + a.w)
    }

    operator fun minus(a: Tuple4): Tuple4 {
        return tuple(this.x - a.x, this.y - a.y, this.z - a.z, this.w - a.w)
    }

    operator fun unaryMinus(): Tuple4 {
        return tuple(-this.x, -this.y, -this.z, -this.w)
    }

    operator fun times(multiplier: Float): Tuple4 {
        return tuple(
                this.x * multiplier,
                this.y * multiplier,
                this.z * multiplier,
                this.w * multiplier
        )
    }

    operator fun div(divider: Float): Tuple4 {
        return tuple(
                this.x / divider,
                this.y / divider,
                this.z / divider,
                this.w / divider
        )
    }

    fun magnitude(): Float {
        return sqrt(this.x*this.x + this.y*this.y + this.z*this.z + this.w*this.w)
    }

    fun normalize(): Tuple4 {
        val m = this.magnitude()
        return vector(this.x / m, this.y / m, this.z / m)
    }

    fun dot(t: Tuple4): Float {
        return  this.x * t.x +
                this.y * t.y +
                this.z * t.z +
                this.w * t.w
    }

    fun cross(t: Tuple4): Tuple4 {
        return vector(  this.y * t.z - this.z * t.y,
                this.z * t.x - this.x * t.z,
                this.x * t.y - this.y * t.x)
    }
}