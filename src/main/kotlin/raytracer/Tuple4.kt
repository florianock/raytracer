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

    operator fun plus(other: Tuple4): Tuple4 {
        require(!(this.getType() == TupleType.POINT && other.getType() == TupleType.POINT))

        return tuple(this.x + other.x, this.y + other.y, this.z + other.z, this.w + other.w)
    }

    operator fun minus(other: Tuple4): Tuple4 {
        require(!(this.getType() == TupleType.VECTOR && other.getType() == TupleType.POINT))

        return tuple(this.x - other.x, this.y - other.y, this.z - other.z, this.w - other.w)
    }

    operator fun unaryMinus(): Tuple4 {
        require(this.getType() != TupleType.POINT)

        return tuple(-this.x, -this.y, -this.z, -this.w)
    }

    operator fun times(multiplier: Float): Tuple4 {
        require(this.getType() != TupleType.POINT)
        return tuple(
                this.x * multiplier,
                this.y * multiplier,
                this.z * multiplier,
                this.w * multiplier
        )
    }

    operator fun div(divider: Float): Tuple4 {
        require(this.getType() != TupleType.POINT)
        return tuple(
                this.x / divider,
                this.y / divider,
                this.z / divider,
                this.w / divider
        )
    }

    fun magnitude(): Float {
        require(this.getType() != TupleType.POINT)
        return sqrt(this.x*this.x + this.y*this.y + this.z*this.z + this.w*this.w)
    }

    fun normalize(): Tuple4 {
        require(this.getType() != TupleType.POINT)

        val m = this.magnitude()
        return vector(this.x / m, this.y / m, this.z / m)
    }

    fun dot(other: Tuple4): Float {
        require(!(this.getType() == TupleType.POINT || other.getType() == TupleType.POINT))
        return  this.x * other.x +
                this.y * other.y +
                this.z * other.z +
                this.w * other.w
    }

    fun cross(other: Tuple4): Tuple4 {
        require(!(this.getType() == TupleType.POINT || other.getType() == TupleType.POINT))
        return vector(  this.y * other.z - this.z * other.y,
                        this.z * other.x - this.x * other.z,
                        this.x * other.y - this.y * other.x)
    }
}

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