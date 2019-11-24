package raytracer

data class Canvas(val width: Int, val height: Int) {
    private var canvas =
        Array(width) {
            Array(height) {
                color(0f, 0f, 0f)
            }
        }

    fun getPixels(): List<Array<Tuple3>> {
        return canvas.toList()
    }

    fun getRow(num: Int): Array<Tuple3>  {
        return canvas[num];
    }

    fun writePixel(row: Int, col: Int, color: Tuple3) {
        canvas[row][col] = color
    }

    fun pixelAt(row: Int, col: Int): Tuple3 {
        return canvas[row][col]
    }

    fun toPpm(): String {
        return ppmHeader() + canvasToPpm()
    }

    private fun canvasToPpm(): String {
        return "2"
    }

    private fun ppmHeader(): String {
        return "P3\n${width} ${height}\n255\n"
    }
}

fun canvas(width: Int, height: Int): Canvas {
    return Canvas(width, height)
}