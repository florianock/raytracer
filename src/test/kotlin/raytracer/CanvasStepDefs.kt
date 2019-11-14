package raytracer

import io.cucumber.java8.En
import kotlin.test.assertEquals

class CanvasStepDefs(private var world: MutableMap<String, Any>): En {

    init {
        Given("c ← canvas\\({int}, {int})") { width: Int, height: Int ->
            world["c"] = canvas(width, height)
        }

        Given("red ← color\\({int}, {int}, {int})") { r: Int, g: Int, b: Int ->
            world["red"] = color(r.toFloat(), g.toFloat(), b.toFloat())
        }

        Then("c.width = {int}") { i: Int ->
            val c = world["c"] as Canvas
            assertEquals(i, c.width)
        }

        Then("c.height = {int}") { i: Int ->
            val c = world["c"] as Canvas
            assertEquals(i, c.height)
        }

        Then("^every pixel of c is color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { red: Float, green: Float, blue: Float ->
            val c = world["c"] as Canvas

            c.rows.forEach { row ->
                row.forEach { pixel ->
                    assertEquals(color(red, green, blue), pixel)
                }
            }
        }

        When("^write_pixel\\(c, (\\d+), (\\d+), (\\w+)\\)$") { row: Int, col: Int, colour: String ->
            val r = world[colour] as Tuple3
            val c = world["c"] as Canvas
            c.writePixel(row, col, r)
        }

        Then("^pixel_at\\(c, (\\d+), (\\d+)\\) = (\\w+)$") { row: Int, col: Int, colour: String ->
            val c = world["c"] as Canvas
            val red = world[colour] as Tuple3
            assertEquals(red, c.pixelAt(row, col))
        }

        When("ppm ← canvas_to_ppm\\(c)") {
            val c = world["c"] as Canvas
            val ppm = c.toPpm()
            world["ppm"] = ppm
        }

        Then("lines {int}-{int} of ppm are") { l1: Int, l2: Int, docString: String ->
            val ppm = world["ppm"] as String
            assertEquals(docString, ppm)
        }
    }
}
