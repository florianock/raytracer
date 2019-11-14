//package raytracer
//
//data class Canvas(val width: Int, val height: Int) {
//    var rows =
//        Array(height) {
//            Array(width) {
//                color(0f, 0f, 0f)
//            }
//        }
//
//    fun getRow(num: Int): Array<Tuple3>  {
//        return rows[num];
//    }
//
//    fun writePixel(row: Int, col: Int, color: Tuple3) {
//        rows[row][col] = color
//    }
//
//    fun pixelAt(row: Int, col: Int): Tuple3 {
//        return rows[row][col]
//    }
//
//    fun toPpm(): String {
//        return ppmHeader()
//    }
//
//    private fun ppmHeader(): String {
//        return "P3\n${width} ${height}\n255"
//    }
//}
//
//fun canvas(width: Int, height: Int): Canvas {
//    return Canvas(width, height)
//}