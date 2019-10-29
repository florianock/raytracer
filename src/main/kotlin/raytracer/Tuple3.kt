package raytracer

data class Tuple3(val red: Float, val green: Float, val blue: Float) {

    override fun equals(other: Any?): Boolean {
        val a = other as Tuple3
        val epsilon = 0.00001
        return  this.red - a.red < epsilon &&
                this.green - a.green < epsilon &&
                this.blue - a.blue < epsilon
    }

    operator fun plus(a: Tuple3): Tuple3 {
        return tuple(this.red + a.red, this.green + a.green, this.blue + a.blue)
    }

    operator fun minus(a: Tuple3): Tuple3 {
        return tuple(this.red + a.red, this.green + a.green, this.blue + a.blue)
    }

    operator fun times(multiplier: Float): Tuple3 {
        return tuple(
                this.red * multiplier,
                this.green * multiplier,
                this.blue * multiplier
        )
    }

    operator fun times(other: Tuple3): Tuple3 {
        return tuple(
                this.red * other.red,
                this.green * other.green,
                this.blue * other.blue
        )
    }

    override fun hashCode(): Int {
        var result = red.hashCode()
        result = 31 * result + green.hashCode()
        result = 31 * result + blue.hashCode()
        return result
    }
}