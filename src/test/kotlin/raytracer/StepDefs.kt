package raytracer

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.cucumber.java8.En
import junit.framework.TestCase.*
import kotlin.math.abs
import kotlin.math.sqrt
import kotlin.test.assertFailsWith

class StepDefs: En {
    private var world: MutableMap<String, Any> = mutableMapOf()

    @Given("^(\\w+) ← tuple\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$")
    fun initializeTupleOf4(a: String, x: Float, y: Float, z: Float, w: Float) {
        world[a] = tuple(x, y, z, w)
    }

    @Given("^(\\w+) ← (\\w+)\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$")
    fun initializeTupleOf3(a: String, ctr: String, x: Float, y: Float, z: Float) {
        val obj = when (ctr) {
            "point" -> point(x, y, z)
            "vector" -> vector(x, y, z)
            "color" -> color(x, y, z)
            else -> {
                throw IllegalArgumentException()
            }
        }
        world[a] = obj
    }

    @When("norm ← normalize\\(v)")
    fun normIsNormalizeV() {
        val v = world["v"] as Tuple4
        world["norm"] = v.normalize()
    }

    @Then("^(\\w+).x = ([-+]?[0-9]*\\.?[0-9]+)$")
    fun tupleFieldXIsX(key: String, x: Float){
        val a = world[key] as Tuple4
        assertEquals(x, a.x)
    }

    @Then("^(\\w+).y = ([-+]?[0-9]*\\.?[0-9]+)$")
    fun tupleFieldYIsY(key: String, y: Float){
        val a = world[key] as Tuple4
        assertEquals(y, a.y)
    }

    @Then("^(\\w+).z = ([-+]?[0-9]*\\.?[0-9]+)$")
    fun tupleFieldZIsZ(key: String, z: Float){
        val a = world[key] as Tuple4
        assertEquals(z, a.z)
    }

    @Then("^(\\w+).w = ([-+]?[0-9]*\\.?[0-9]+)$")
    fun tupleFieldWIsW(key: String, w: Float){
        val a = world[key] as Tuple4
        assertEquals(w, a.w)
    }

    @Then("^(\\w+) is( | not )a (\\w+)$")
    fun testType(key: String, mod: String, type: String) {
        val a = world[key] as Tuple4
        when (mod) {
            " " -> assertEquals(type.toLowerCase(), a.getType().toString().toLowerCase())
            " not " -> assertTrue(type.toLowerCase() != a.getType().toString().toLowerCase())
            else -> throw IllegalArgumentException()
        }
    }

    @Then("([-]?)(\\w+) = tuple\\(([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+)\\)")
    fun keyEqualsTuple(neg: String, key: String, x: Float, y: Float, z: Float, w: Float) {
        val t = world[key] as Tuple4
        if (neg == "-") {
            assertEquals(Tuple4(x, y, z, w), -t)
        } else {
            assertEquals(Tuple4(x, y, z, w), t)
        }
    }

    @Then("a == b is true")
    fun tuplesEqual() {
        val a = world["a"] as Tuple4
        val b = world["b"] as Tuple4
        assertTrue(a == b)
    }

    @Then("a == b is false")
    fun tuplesEqualIsFalse() {
        val a = world["a"] as Tuple4
        val b = world["b"] as Tuple4
        assertFalse(a == b)
    }

    @Then("a != b is true")
    fun tuplesNotEqual() {
        val a = world["a"] as Tuple4
        val b = world["b"] as Tuple4
        assertTrue(a != b)
    }

    @Then("a != b is false")
    fun tuplesNotEqualIsFalse() {
        val a = world["a"] as Tuple4
        val b = world["b"] as Tuple4
        assertFalse(a != b)
    }

    @Then("^(\\w+) ([+]) (\\w+) = tuple\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$")
    fun tuplePlusTuple(tupleA: String, op: String, tupleB: String, x: Float, y: Float, z: Float, w: Float) {
        val a = world[tupleA] as Tuple4
        val b = world[tupleB] as Tuple4
        when (op) {
            "+" -> assertEquals(tuple(x, y, z, w), a + b)
            else -> throw IllegalArgumentException()
        }
    }

    @Then("^(\\w\\d?) ([+-]) (\\w\\d?) throws IllegalArgumentException$")
    fun someOpsThrowException(tuple1: String, op: String, tuple2: String) {
        val t1 = world[tuple1] as Tuple4
        val t2 = world[tuple2] as Tuple4
        assertFailsWith<IllegalArgumentException>{
            when (op) {
                "+" -> t1 + t2
                "-" -> t1 - t2
            }
        }
    }

    @Then("-p throws IllegalArgumentException")
    fun negatingAPointThrowsException() {
        val p = world["p"] as Tuple4
        assertFailsWith<IllegalArgumentException> {
            -p
        }
    }

    @Then("^(\\w) ([*/]) ([-+]?\\d*\\.?\\d+) throws IllegalArgumentException$")
    fun someOpsThrowException(point: String, op: String, float: Float) {
        val p = world[point] as Tuple4
        assertFailsWith<IllegalArgumentException>{
            when (op) {
                "*" -> p * float
                "/" -> p / float
            }
        }
    }

    @Then("^(\\w+) ([-]) (\\w+) = (vector|point)\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$")
    fun tupleMinusTuple(pointA: String, op: String, pointB: String, ctr: String, x: Float, y: Float, z: Float) {
        val a = world[pointA] as Tuple4
        val b = world[pointB] as Tuple4

        val expected: Tuple4 = when (ctr) {
            "vector" -> vector(x, y, z)
            "point" -> point(x, y, z)
            else -> throw IllegalArgumentException()
        }

        when (op) {
            "-" -> assertEquals(expected, a - b)
            else -> throw IllegalArgumentException()
        }
    }

    @Then("^a ([*/]) ([-+]?\\d*\\.?\\d+) = tuple\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$")
    fun scalarMultiplyingATuple(op: String, multiplier: Float, x: Float, y: Float, z: Float, w: Float) {
        val a = world["a"] as Tuple4
        val result = when (op) {
            "*" -> a * multiplier
            "/" -> a / multiplier
            else -> throw IllegalArgumentException()
        }
        assertEquals(tuple(x, y, z, w), result)
    }

    @Then("^magnitude\\(v\\) =( | √)([-+]?\\d*\\.?\\d+)$")
    fun magnitudeOfVEquals(sw: String, mag: Float) {
        val v = world["v"] as Tuple4
        var m = mag
        if (sw == " √") {
            m = sqrt(mag)
        }
        assertEquals(m, v.magnitude())
    }

    @Then("^normalize\\(v\\) = vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$")
    fun normalizeVector(x: Float, y: Float, z: Float) {
        val v = world["v"] as Tuple4
        assertEquals(vector(x, y, z), v.normalize())
    }

    @Then("^(normalize|magnitude)\\(p\\) throws IllegalArgumentException$")
    fun normalizeOrMagnitudeOfPointThrowsException(func: String) {
        val p = world["p"] as Tuple4
        assertFailsWith<IllegalArgumentException> {
            when (func) {
                "normalize" -> p.normalize()
                "magnitude" -> p.magnitude()
            }
        }
    }

    @Then("^normalize\\(v\\) = approximately vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$")
    fun normalizeVectorEpsilon(x: Float, y: Float, z: Float) {
        val v = world["v"] as Tuple4
        val expected = vector(x, y, z)
        val result = v.normalize()
        assertEqualsApprox(expected, result)
    }

    @Then("^magnitude\\(norm\\) = ([-+]?\\d*\\.?\\d+)$")
    fun magnitudeNormalizedVector(m: Float) {
        val norm = world["norm"] as Tuple4
        assertEqualsApprox(m, norm.magnitude())
    }

    @Then("^dot\\(a, b\\) = ([-+]?\\d*\\.?\\d+)$")
    fun dotProductTest(dp: Float) {
        val a = world["a"] as Tuple4
        val b = world["b"] as Tuple4
        assertEquals(dp, a.dot(b))
    }

    @Then("^dot\\((\\w), (\\w)\\) throws exception$")
    fun dotProductWithPointThrowsException(t1: String, t2: String) {
        val t1 = world[t1] as Tuple4
        val t2 = world[t2] as Tuple4
        assertFailsWith<IllegalArgumentException> {
            t1.dot(t2)
        }
    }

    @Then("^cross\\((\\w+), (\\w+)\\) = vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$")
    fun crossProductTest(a: String, b: String, x: Float, y: Float, z: Float) {
        val c = world[a] as Tuple4
        val d = world[b] as Tuple4
        assertEquals(vector(x, y, z), c.cross(d))
    }

    @Then("^cross\\((\\w), (\\w)\\) throws IllegalArgumentException$")
    fun crossProductOnPointThrowsException(t1: String, t2: String) {
        val t1 = world[t1] as Tuple4
        val t2 = world[t2] as Tuple4
        assertFailsWith<IllegalArgumentException> {
            t1.cross(t2)
        }
    }

    @Then("^c\\.red = ([-+]?\\d*\\.?\\d+)$")
    fun cRedEquals(f: Float) {
        val c = world["c"] as Tuple3
        assertEquals(f, c.red)
    }

    @Then("^c\\.green = ([-+]?\\d*\\.?\\d+)$")
    fun cGreenEquals(f: Float) {
        val c = world["c"] as Tuple3
        assertEquals(f, c.green)
    }

    @Then("^c\\.blue = ([-+]?\\d*\\.?\\d+)$")
    fun cBlueEquals(f: Float) {
        val c = world["c"] as Tuple3
        assertEquals(f, c.blue)
    }

    @Then("^c1 \\+ c2 = color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$")
    fun addingColors(red: Float, green: Float, blue: Float) {
        val c1 = world["c1"] as Tuple3
        val c2 = world["c2"] as Tuple3
        assertEquals(color(red, green, blue), c1 + c2)
    }

    @Then("^c1 - c2 = color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$")
    fun subtractingColors(red: Float, green: Float, blue: Float) {
        val c1 = world["c1"] as Tuple3
        val c2 = world["c2"] as Tuple3
        assertEquals(color(red, green, blue), c1 - c2)
    }

    @Then("^c \\* ([-+]?\\d*\\.?\\d+) = color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$")
    fun multiplyingColorWithScalar(multiplier: Float, red: Float, green: Float, blue: Float) {
        val c = world["c"] as Tuple3
        assertEquals(color(red, green, blue), c * multiplier)
    }

    @Then("^c1 \\* c2 = color\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$")
    fun multiplyingColorWithColor(red: Float, green: Float, blue: Float) {
        val c1 = world["c1"] as Tuple3
        val c2 = world["c2"] as Tuple3
        assertEquals(color(red, green, blue), c1 * c2)
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
