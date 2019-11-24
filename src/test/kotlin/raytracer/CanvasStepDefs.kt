package raytracer

import io.cucumber.java8.En
import junit.framework.TestCase.*

class CanvasStepDefs(private var world: World) : En {

    init {
        Given("c ← canvas\\({int}, {int})") { width: Int, height: Int ->
            world.canvas = canvas(width, height)
        }

        Given("red ← color\\({int}, {int}, {int})") { r: Int, g: Int, b: Int ->
            world.red = color(r.toFloat(), g.toFloat(), b.toFloat())
        }

        Then("c.width = {int}") { i: Int ->
            val c = world.canvas
            assertEquals(i, c.width)
        }

        Then("c.height = {int}") { i: Int ->
            val c = world.canvas
            assertEquals(i, c.height)
        }

        Then("^every pixel of c is color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { red: Float, green: Float, blue: Float ->
            val c = world.canvas

            c.getPixels().forEach { row ->
                row.forEach { pixel ->
                    assertEquals(color(red, green, blue), pixel)
                }
            }
        }

        When("^write_pixel\\(c, (\\d+), (\\d+), red\\)$") { row: Int, col: Int ->
            world.canvas.writePixel(row, col, world.red)
        }

        When("^write_pixel\\(c, (\\d+), (\\d+), c1\\)$") { row: Int, col: Int ->
            world.canvas.writePixel(row, col, world.c1)
        }

        When("^write_pixel\\(c, (\\d+), (\\d+), c2\\)$") { row: Int, col: Int ->
            world.canvas.writePixel(row, col, world.c2)
        }

        When("^write_pixel\\(c, (\\d+), (\\d+), c3\\)$") { row: Int, col: Int ->
            world.canvas.writePixel(row, col, world.c3)
        }

        Then("^pixel_at\\(c, (\\d+), (\\d+)\\) = red$") { row: Int, col: Int ->
            assertEquals(world.red, world.canvas.pixelAt(row, col))
        }

        When("ppm ← canvas_to_ppm\\(c)") {
            world.ppm = world.canvas.toPpm()
        }

        Then("lines {int}-{int} of ppm are") { l1: Int, l2: Int, docString: String ->
//            var lines =
            assertEquals(docString, world.ppm)
        }
    }
}
