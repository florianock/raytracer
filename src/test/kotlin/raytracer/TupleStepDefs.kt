package raytracer

import io.cucumber.java8.En
import junit.framework.TestCase.*
import kotlin.math.abs
import kotlin.math.sqrt
import kotlin.test.assertFailsWith

class TupleStepDefs(private var world: World) : En {

    init {

//        # Givens

        Given("^a ← tuple\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float, w: Float ->
            world.a = tuple(x, y, z, w)
        }

        Given("^a ← vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
            world.a = vector(x, y, z)
        }

        Given("^a1 ← tuple\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float, w: Float ->
            world.a1 = tuple(x, y, z, w)
        }

        Given("^a2 ← tuple\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float, w: Float ->
            world.a2 = tuple(x, y, z, w)
        }

        Given("^b ← tuple\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float, w: Float ->
            world.b = tuple(x, y, z, w)
        }

        Given("^b ← vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
            world.b = vector(x, y, z)
        }

        Given("^p ← point\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
            world.p = point(x, y, z)
        }

        Given("^p1 ← point\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
            world.p1 = point(x, y, z)
        }

        Given("^p2 ← point\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
            world.p2 = point(x, y, z)
        }

        Given("^v ← vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
            world.v = vector(x, y, z)
        }

        Given("^v1 ← vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
            world.v1 = vector(x, y, z)
        }

        Given("^v2 ← vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
            world.v2 = vector(x, y, z)
        }

        Given("^c ← color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
            world.c = color(x, y, z)
        }

        Given("^c1 ← color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
            world.c1 = color(x, y, z)
        }

        Given("^c2 ← color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
            world.c2 = color(x, y, z)
        }

        Given("^c3 ← color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
            world.c3 = color(x, y, z)
        }

        Given("zero ← vector\\({int}, {int}, {int})") { x: Int, y: Int, z: Int ->
            world.zero = vector(x.toFloat(), y.toFloat(), z.toFloat())
        }

        When("^norm ← normalize\\(v\\)$") {
            val v = world.v
            world.norm = v.normalize()
        }

//        # Instantiation

        Then("^a\\.x = ([-+]?[0-9]*\\.?[0-9]+)$") { x: Float ->
            assertEquals(x, world.a.x)
        }

        Then("^a\\.y = ([-+]?[0-9]*\\.?[0-9]+)$") { y: Float ->
            assertEquals(y, world.a.y)
        }

        Then("^a\\.z = ([-+]?[0-9]*\\.?[0-9]+)$") { z: Float ->
            assertEquals(z, world.a.z)
        }

        Then("^a\\.w = ([-+]?[0-9]*\\.?[0-9]+)$") { w: Float ->
            assertEquals(w, world.a.w)
        }

        Then("^a is( | not )a (\\w+)$") { mod: String, type: String ->
            when (mod) {
                " " -> assertEquals(type.toLowerCase(), world.a.getType().toString().toLowerCase())
                " not " -> assertTrue(type.toLowerCase() != world.a.getType().toString().toLowerCase())
                else -> throw IllegalArgumentException()
            }
        }

        Then("p = tuple\\(([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+)\\)") { x: Float, y: Float, z: Float, w: Float ->
            assertEquals(Tuple4(x, y, z, w), world.p)
        }

        Then("-a = tuple\\(([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+)\\)") { x: Float, y: Float, z: Float, w: Float ->
            assertEquals(Tuple4(x, y, z, w), -world.a)
        }

        Then("v = tuple\\(([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+)\\)") { x: Float, y: Float, z: Float, w: Float ->
            assertEquals(Tuple4(x, y, z, w), world.v)
        }

//       # Equality

        Then("a == b is true") {
            assertTrue(world.a == world.b)
        }

        Then("a == b is false") {
            assertFalse(world.a == world.b)
        }

        Then("a != b is true") {
            assertTrue(world.a != world.b)
        }

        Then("a != b is false") {
            assertFalse(world.a != world.b)
        }

//        # Arithmetic

        Then("^a1 \\+ a2 = tuple\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float, w: Float ->
            assertEquals(tuple(x, y, z, w), world.a1 + world.a2)
        }

        Then("^p1 \\+ p2 throws IllegalArgumentException$") {
            assertFailsWith<IllegalArgumentException> {
                world.p1 + world.p2
            }
        }

        Then("-p throws IllegalArgumentException") {
            assertFailsWith<IllegalArgumentException> {
                -world.p
            }
        }

        Then("^p ([*/]) ([-+]?\\d*\\.?\\d+) throws IllegalArgumentException$") { op: String, float: Float ->
            assertFailsWith<IllegalArgumentException>{
                when (op) {
                    "*" -> world.p * float
                    "/" -> world.p / float
                }
            }
        }

        Then("^v1 - v2 = vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
            val actual = world.v1 - world.v2
            val expected = vector(x, y, z)

            assertEquals(expected, actual)
        }

        Then("^p1 - p2 = vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
            val actual = world.p1 - world.p2
            val expected = vector(x, y, z)

            assertEquals(expected, actual)
        }

        Then("^p - v = point\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
            val expected = point(x, y, z)
            val actual = world.p - world.v

            assertEquals(expected, actual)
        }

        Then("^zero - v = vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
            val expected = vector(x, y, z)
            val actual = world.zero - world.v

            assertEquals(expected, actual)
        }

        Then("v - p throws IllegalArgumentException") {
            assertFailsWith<IllegalArgumentException> {
                world.v - world.p
            }
        }

        Then("^a ([*/]) ([-+]?\\d*\\.?\\d+) = tuple\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { op: String, multiplier: Float, x: Float, y: Float, z: Float, w: Float ->
            val result = when (op) {
                "*" -> world.a * multiplier
                "/" -> world.a / multiplier
                else -> throw IllegalArgumentException()
            }
            assertEquals(tuple(x, y, z, w), result)
        }

//        # Magnitude & Normalize

        Then("^magnitude\\(v\\) =( | √)([-+]?\\d*\\.?\\d+)$") { sw: String, mag: Float ->
            var expected = mag
            if (sw == " √") {
                expected = sqrt(mag)
            }
            assertEquals(expected, world.v.magnitude())
        }

        Then("^normalize\\(v\\) = vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
            assertEquals(vector(x, y, z), world.v.normalize())
        }

        Then("^(normalize|magnitude)\\(p\\) throws IllegalArgumentException$") { func: String ->
            assertFailsWith<IllegalArgumentException> {
                when (func) {
                    "normalize" -> world.p.normalize()
                    "magnitude" -> world.p.magnitude()
                }
            }
        }

        Then("^normalize\\(v\\) = approximately vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
            val expected = vector(x, y, z)
            val actual = world.v.normalize()

            assertEqualsApprox(expected, actual)
        }

        Then("^magnitude\\(norm\\) = ([-+]?\\d*\\.?\\d+)$") { expected: Float ->
            assertEqualsApprox(expected, world.norm.magnitude())
        }

//        # Dot & Cross products

        Then("^dot\\(a, b\\) = ([-+]?\\d*\\.?\\d+)$") { expected: Float ->
            assertEquals(expected, world.a.dot(world.b))
        }

        Then("^dot\\(v, p\\) throws exception$") {
            assertFailsWith<IllegalArgumentException> {
                world.v.dot(world.p)
            }
        }

        Then("^dot\\(p, v\\) throws exception$") {
            assertFailsWith<IllegalArgumentException> {
                world.p.dot(world.v)
            }
        }

        Then("^cross\\(a, b\\) = vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
            val expected = vector(x, y, z)
            val actual = world.a.cross(world.b)

            assertEquals(expected, actual)
        }

        Then("^cross\\(b, a\\) = vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
            val expected = vector(x, y, z)
            val actual = world.b.cross(world.a)

            assertEquals(expected, actual)
        }

        Then("^cross\\(v, p\\) throws IllegalArgumentException$") {
            assertFailsWith<IllegalArgumentException> {
                world.v.cross(world.p)
            }
        }

        Then("^cross\\(p, v\\) throws IllegalArgumentException$") {
            assertFailsWith<IllegalArgumentException> {
                world.p.cross(world.v)
            }
        }

//        # Colours

        Then("^c\\.red = ([-+]?\\d*\\.?\\d+)$") { f: Float ->
            assertEquals(f, world.c.red)
        }

        Then("^c\\.green = ([-+]?\\d*\\.?\\d+)$") { f: Float ->
            assertEquals(f, world.c.green)
        }

        Then("^c\\.blue = ([-+]?\\d*\\.?\\d+)$") { f: Float ->
            assertEquals(f, world.c.blue)
        }

        Then("^c1 \\+ c2 = color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { red: Float, green: Float, blue: Float ->
            assertEquals(color(red, green, blue), world.c1 + world.c2)
        }

        Then("^c1 - c2 = color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { red: Float, green: Float, blue: Float ->
            assertEquals(color(red, green, blue), world.c1 - world.c2)
        }

        Then("^c \\* ([-+]?\\d*\\.?\\d+) = color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { multiplier: Float, red: Float, green: Float, blue: Float ->
            assertEquals(color(red, green, blue), world.c * multiplier)
        }

        Then("^c1 \\* c2 = color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { red: Float, green: Float, blue: Float ->
            assertEquals(color(red, green, blue), world.c1 * world.c2)
        }
    }

    private fun assertEqualsApprox(a: Float, b: Float, eps: Float = 0.0001f) {
        assertTrue(abs(a - b) < eps)
    }

    private fun assertEqualsApprox(a: Tuple4, b: Tuple4, eps: Float = 0.0001f) {
        assertTrue(abs(a.x - b.x) < eps)
        assertTrue(abs(a.y - b.y) < eps)
        assertTrue(abs(a.z - b.z) < eps)
        assertTrue(abs(a.w - b.w) < eps)
    }
}
