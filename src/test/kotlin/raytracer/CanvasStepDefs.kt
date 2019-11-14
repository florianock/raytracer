//package raytracer
//
//import io.cucumber.java8.En
//import kotlin.test.assertEquals
//
//class CanvasStepDefs(var world: World) : En {
//
//    init {
//        Given("c ← canvas\\({int}, {int})") { width: Int, height: Int ->
//            world.canvas = canvas(width, height)
//        }
//
//        Given("red ← color\\({int}, {int}, {int})") { r: Int, g: Int, b: Int ->
//            world.red = color(r.toFloat(), g.toFloat(), b.toFloat())
//        }
//
//        Then("c.width = {int}") { i: Int ->
//            val c = world.canvas
//            assertEquals(i, c.width)
//        }
//
//        Then("c.height = {int}") { i: Int ->
//            val c = world.canvas
//            assertEquals(i, c.height)
//        }
//
//        Then("^every pixel of c is color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { red: Float, green: Float, blue: Float ->
//            val c = world.canvas
//
//            c.rows.forEach { row ->
//                row.forEach { pixel ->
//                    assertEquals(color(red, green, blue), pixel)
//                }
//            }
//        }
//
//        When("^write_pixel\\(c, (\\d+), (\\d+), c1\\)$") { row: Int, col: Int ->
//            val r = world.c1
//            val c = world.canvas
//            c.writePixel(row, col, r)
//        }
//
//        When("^write_pixel\\(c, (\\d+), (\\d+), c2\\)$") { row: Int, col: Int ->
//            val r = world.c2
//            val c = world.canvas
//            c.writePixel(row, col, r)
//        }
//
//        When("^write_pixel\\(c, (\\d+), (\\d+), c3\\)$") { row: Int, col: Int ->
//            val r = world.c3
//            val c = world.canvas
//            c.writePixel(row, col, r)
//        }
//
//        Then("^pixel_at\\(c, (\\d+), (\\d+)\\) = red$") { row: Int, col: Int ->
//            val c = world.canvas
//            val red = world.red
//            assertEquals(red, c.pixelAt(row, col))
//        }
//
//        When("ppm ← canvas_to_ppm\\(c)") {
//            val c = world.canvas
//            val ppm = c.toPpm()
//            world.ppm = ppm
//        }
//
//        Then("lines {int}-{int} of ppm are") { l1: Int, l2: Int, docString: String ->
//            val ppm = world.ppm
//            assertEquals(docString, ppm)
//        }
//    }
//}
