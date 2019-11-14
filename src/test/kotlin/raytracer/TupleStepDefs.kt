package raytracer

import io.cucumber.java8.En
import junit.framework.TestCase.*
import kotlin.math.abs
import kotlin.math.sqrt
import kotlin.test.assertFailsWith

class TupleStepDefs(var world: World) : En {

    init {
        Given("^a ← tuple\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float, w: Float ->
            world.a = tuple(x, y, z, w)
        }

//        Given("^a ← vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
//            world.a = vector(x, y, z)
//        }
//
//        Given("^a1 ← tuple\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float, w: Float ->
//            world.a1 = tuple(x, y, z, w)
//        }
//
//        Given("^a2 ← tuple\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float, w: Float ->
//            world.a2 = tuple(x, y, z, w)
//        }
//
//        Given("^b ← tuple\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float, w: Float ->
//            world.b = tuple(x, y, z, w)
//        }
//
//        Given("^b ← vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
//            world.b = vector(x, y, z)
//        }
//
//        Given("^p ← point\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
//            world.p = point(x, y, z)
//        }
//
//        Given("^p1 ← point\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
//            world.p1 = point(x, y, z)
//        }
//
//        Given("^p2 ← point\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
//            world.p2 = point(x, y, z)
//        }
//
//        Given("^v ← vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
//            world.v = vector(x, y, z)
//        }
//
//        Given("^v1 ← vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
//            world.v1 = vector(x, y, z)
//        }
//
//        Given("^v2 ← vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
//            world.v2 = vector(x, y, z)
//        }
//
//        Given("^c ← color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
//            world.c = color(x, y, z)
//        }
//
//        Given("^c1 ← color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
//            world.c1 = color(x, y, z)
//        }
//
//        Given("^c2 ← color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
//            world.c2 = color(x, y, z)
//        }
//
//        Given("^c3 ← color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
//            world.c3 = color(x, y, z)
//        }
//
//        Given("zero ← vector\\({int}, {int}, {int})") { x: Int, y: Int, z: Int ->
//            world.zero = vector(x.toFloat(), y.toFloat(), z.toFloat())
//        }
//
//        When("norm ← normalize\\(v)") {
//            val v = world.v
//            world.norm = v.normalize()
//        }
//
        Then("^a\\.x = ([-+]?[0-9]*\\.?[0-9]+)$") { x: Float ->
            val a = world.a
            assertEquals(x, a.x)
        }

        Then("^a\\.y = ([-+]?[0-9]*\\.?[0-9]+)$") { y: Float ->
            val a = world.a
            assertEquals(y, a.y)
        }

        Then("^a\\.z = ([-+]?[0-9]*\\.?[0-9]+)$") { z: Float ->
            val a = world.a
            assertEquals(z, a.z)
        }

        Then("^a\\.w = ([-+]?[0-9]*\\.?[0-9]+)$") { w: Float ->
            val a = world.a
            assertEquals(w, a.w)
        }

        Then("^a is( | not )a (\\w+)$") { mod: String, type: String ->
            val a = world.a
            when (mod) {
                " " -> assertEquals(type.toLowerCase(), a.getType().toString().toLowerCase())
                " not " -> assertTrue(type.toLowerCase() != a.getType().toString().toLowerCase())
                else -> throw IllegalArgumentException()
            }
        }
//
//        Then("p = tuple\\(([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+)\\)") { x: Float, y: Float, z: Float, w: Float ->
//            val p = world.p
//            assertEquals(Tuple4(x, y, z, w), p)
//        }
//
//        Then("-a = tuple\\(([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+)\\)") { x: Float, y: Float, z: Float, w: Float ->
//            val a = world.a
//            assertEquals(Tuple4(x, y, z, w), -a)
//        }
//
//        Then("v = tuple\\(([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+)\\)") { x: Float, y: Float, z: Float, w: Float ->
//            val v = world.v
//            assertEquals(Tuple4(x, y, z, w), v)
//        }
//
//        Then("a == b is true") {
//            val a = world.a
//            val b = world.b
//            assertTrue(a == b)
//        }
//
//        Then("a == b is false") {
//            val a = world.a
//            val b = world.b
//            assertFalse(a == b)
//        }
//
//        Then("a != b is true") {
//            val a = world.a
//            val b = world.b
//            assertTrue(a != b)
//        }
//
//        Then("a != b is false") {
//            val a = world.a
//            val b = world.b
//            assertFalse(a != b)
//        }
//
//        Then("^a1 \\+ a2 = tuple\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float, w: Float ->
//            val a = world.a1
//            val b = world.a2
//            assertEquals(tuple(x, y, z, w), a + b)
//        }
//
//        Then("^a1 \\+ a2 = tuple\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float, w: Float ->
//            val a = world.a1
//            val b = world.a2
//            assertEquals(tuple(x, y, z, w), a + b)
//        }
//
//        Then("^p1 \\+ p2 throws IllegalArgumentException$") {
//            val t1 = world.p1
//            val t2 = world.p2
//            assertFailsWith<IllegalArgumentException> {
//                t1 + t2
//            }
//        }
//
//        Then("-p throws IllegalArgumentException") {
//            val p = world.p
//            assertFailsWith<IllegalArgumentException> {
//                -p
//            }
//        }
//
//        Then("^(\\w) ([*/]) ([-+]?\\d*\\.?\\d+) throws IllegalArgumentException$") { point: String, op: String, float: Float ->
//            val p = world[point] as Tuple4
//            assertFailsWith<IllegalArgumentException>{
//                when (op) {
//                    "*" -> p * float
//                    "/" -> p / float
//                }
//            }
//        }
//
//        Then("^(\\w+) ([-]) (\\w+) = (vector|point)\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { pointA: String, op: String, pointB: String, ctr: String, x: Float, y: Float, z: Float ->
//            val a = world[pointA] as Tuple4
//            val b = world[pointB] as Tuple4
//
//            val expected: Tuple4 = when (ctr) {
//                "vector" -> vector(x, y, z)
//                "point" -> point(x, y, z)
//                else -> throw IllegalArgumentException()
//            }
//
//            when (op) {
//                "-" -> assertEquals(expected, a - b)
//                else -> throw IllegalArgumentException()
//            }
//        }
//
//        Then("^a ([*/]) ([-+]?\\d*\\.?\\d+) = tuple\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { op: String, multiplier: Float, x: Float, y: Float, z: Float, w: Float ->
//            val a = world.a as Tuple4
//            val result = when (op) {
//                "*" -> a * multiplier
//                "/" -> a / multiplier
//                else -> throw IllegalArgumentException()
//            }
//            assertEquals(tuple(x, y, z, w), result)
//        }
//
//        Then("^magnitude\\(v\\) =( | √)([-+]?\\d*\\.?\\d+)$") { sw: String, mag: Float ->
//            val v = world.v
//            var m = mag
//            if (sw == " √") {
//                m = sqrt(mag)
//            }
//            assertEquals(m, v.magnitude())
//        }
//
//        Then("^normalize\\(v\\) = vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
//            val v = world.v
//            assertEquals(vector(x, y, z), v.normalize())
//        }
//
//        Then("^(normalize|magnitude)\\(p\\) throws IllegalArgumentException$") { func: String ->
//            val p = world.p
//            assertFailsWith<IllegalArgumentException> {
//                when (func) {
//                    "normalize" -> p.normalize()
//                    "magnitude" -> p.magnitude()
//                }
//            }
//        }
//
//        Then("^normalize\\(v\\) = approximately vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { x: Float, y: Float, z: Float ->
//            val v = world.v
//            val expected = vector(x, y, z)
//            val result = v.normalize()
//            assertEqualsApprox(expected, result)
//        }
//
//        Then("^magnitude\\(norm\\) = ([-+]?\\d*\\.?\\d+)$") { m: Float ->
//            val norm = world.norm
//            assertEqualsApprox(m, norm.magnitude())
//        }
//
//        Then("^dot\\(a, b\\) = ([-+]?\\d*\\.?\\d+)$") { dp: Float ->
//            val a = world.a as Tuple4
//            val b = world.b
//            assertEquals(dp, a.dot(b))
//        }
//
//        Then("^dot\\((\\w), (\\w)\\) throws exception$") { tuple1: String, tuple2: String ->
//            val t1 = world[tuple1] as Tuple4
//            val t2 = world[tuple2] as Tuple4
//            assertFailsWith<IllegalArgumentException> {
//                t1.dot(t2)
//            }
//        }
//
//        Then("^cross\\((\\w+), (\\w+)\\) = vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { a: String, b: String, x: Float, y: Float, z: Float ->
//            val c = world.a
//            val d = world.b
//            assertEquals(vector(x, y, z), c.cross(d))
//        }
//
//        Then("^cross\\((\\w), (\\w)\\) throws IllegalArgumentException$") { tuple1: String, tuple2: String ->
//            val t1 = world[tuple1] as Tuple4
//            val t2 = world[tuple2] as Tuple4
//            assertFailsWith<IllegalArgumentException> {
//                t1.cross(t2)
//            }
//        }
//
//        Then("^c\\.red = ([-+]?\\d*\\.?\\d+)$") { f: Float ->
//            val c = world.c
//            assertEquals(f, c.red)
//        }
//
//        Then("^c\\.green = ([-+]?\\d*\\.?\\d+)$") { f: Float ->
//            val c = world.c
//            assertEquals(f, c.green)
//        }
//
//        Then("^c\\.blue = ([-+]?\\d*\\.?\\d+)$") { f: Float ->
//            val c = world.c
//            assertEquals(f, c.blue)
//        }
//
//        Then("^c1 \\+ c2 = color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { red: Float, green: Float, blue: Float ->
//            val c1 = world.c1
//            val c2 = world.c2
//            assertEquals(color(red, green, blue), c1 + c2)
//        }
//
//        Then("^c1 - c2 = color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { red: Float, green: Float, blue: Float ->
//            val c1 = world.c1
//            val c2 = world.c2
//            assertEquals(color(red, green, blue), c1 - c2)
//        }
//
//        Then("^c \\* ([-+]?\\d*\\.?\\d+) = color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { multiplier: Float, red: Float, green: Float, blue: Float ->
//            val c = world.c
//            assertEquals(color(red, green, blue), c * multiplier)
//        }
//
//        Then("^c1 \\* c2 = color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$") { red: Float, green: Float, blue: Float ->
//            val c1 = world.c1
//            val c2 = world.c2
//            assertEquals(color(red, green, blue), c1 * c2)
//        }
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
