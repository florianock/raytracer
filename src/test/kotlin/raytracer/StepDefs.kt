package raytracer

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.cucumber.java8.En
import junit.framework.TestCase.*
import kotlin.math.abs
import kotlin.math.sqrt

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
//            "color" -> color(x, y, z)
            else -> {
                throw IllegalArgumentException()
            }
        }
        world[a] = obj
    }

    @When("norm ← normalize\\(v)")
    fun normIsNormalizeV() {
        val v = world["v"] as Tuple
        world["norm"] = normalize(v)
    }

    @Then("^(\\w+).x = ([-+]?[0-9]*\\.?[0-9]+)$")
    fun tupleFieldXIsX(key: String, x: Float){
        val a = world[key] as Tuple
        assertEquals(x, a.x)
    }

    @Then("^(\\w+).y = ([-+]?[0-9]*\\.?[0-9]+)$")
    fun tupleFieldYIsY(key: String, y: Float){
        val a = world[key] as Tuple
        assertEquals(y, a.y)
    }

    @Then("^(\\w+).z = ([-+]?[0-9]*\\.?[0-9]+)$")
    fun tupleFieldZIsZ(key: String, z: Float){
        val a = world[key] as Tuple
        assertEquals(z, a.z)
    }

    @Then("^(\\w+).w = ([-+]?[0-9]*\\.?[0-9]+)$")
    fun tupleFieldWIsW(key: String, w: Float){
        val a = world[key] as Tuple
        assertEquals(w, a.w)
    }

    @Then("^(\\w+) is( | not )a (\\w+)$")
    fun testType(key: String, mod: String, type: String) {
        val a = world[key] as Tuple
        when (mod) {
            " " -> assertEquals(type.toLowerCase(), a.getType().toString().toLowerCase())
            " not " -> assertTrue(type.toLowerCase() != a.getType().toString().toLowerCase())
            else -> throw IllegalArgumentException()
        }
    }

    @Then("([-]?)(\\w+) = tuple\\(([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+)\\)")
    fun keyEqualsTuple(neg: String, key: String, x: Float, y: Float, z: Float, w: Float) {
        val t = world[key] as Tuple
        if (neg == "-") {
            assertEquals(Tuple(x, y, z, w), -t)
        } else {
            assertEquals(Tuple(x, y, z, w), t)
        }
    }

    @Then("^(\\w+) ([+-]) (\\w+) = tuple\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$")
    fun tuplePlusTuple(tupleA: String, op: String, tupleB: String, x: Float, y: Float, z: Float, w: Float) {
        val a = world[tupleA] as Tuple
        val b = world[tupleB] as Tuple
        when (op) {
            "+" -> assertEquals(tuple(x, y, z, w), a + b)
            else -> throw IllegalArgumentException()
        }
    }

    @Then("^(\\w+) ([-]) (\\w+) = (\\w+)\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$")
    fun tupleMinusTuple(pointA: String, op: String, pointB: String, ctr: String, x: Float, y: Float, z: Float) {
        val a = world[pointA] as Tuple
        val b = world[pointB] as Tuple

        val expected: Tuple = when (ctr) {
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
        val a = world["a"] as Tuple
        val result = when (op) {
            "*" -> a * multiplier
            "/" -> a / multiplier
            else -> throw IllegalArgumentException()
        }
        assertEquals(tuple(x, y, z, w), result)
    }

    @Then("^magnitude\\(v\\) =( | √)([-+]?\\d*\\.?\\d+)$")
    fun magnitudeOfVEquals(sw: String, mag: Float) {
        val v = world["v"] as Tuple
        var m = mag
        if (sw == " √") {
            m = sqrt(mag)
        }
        assertEquals(m, magnitude(v))
    }

    @Then("^normalize\\(v\\) = vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$")
    fun normalizeVector(x: Float, y: Float, z: Float) {
        val v = world["v"] as Tuple
        assertEquals(vector(x, y, z), normalize(v))
    }

    @Then("^normalize\\(v\\) = approximately vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$")
    fun normalizeVectorEpsilon(x: Float, y: Float, z: Float) {
        val v = world["v"] as Tuple
        val expected = vector(x, y, z)
        val result = normalize(v)
        assertEqualsApprox(expected, result);
    }

    @Then("^magnitude\\(norm\\) = ([-+]?\\d*\\.?\\d+)$")
    fun magnitudeNormalizedVector(m: Float) {
        val norm = world["norm"] as Tuple
        assertEqualsApprox(m, magnitude(norm))
    }

    @Then("^dot\\(a, b\\) = ([-+]?\\d*\\.?\\d+)$")
    fun dotProductTest(dp: Float) {
        val a = world["a"] as Tuple;
        val b = world["b"] as Tuple;
        assertEquals(dp, dot(a, b));
    }

    @Then("^cross\\((\\w+), (\\w+)\\) = vector\\(([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+), ([-+]?\\d*\\.?\\d+)\\)$")
    fun crossProductTest(a: String, b: String, x: Float, y: Float, z: Float) {
        val c = world[a] as Tuple;
        val d = world[b] as Tuple
        assertEquals(vector(x, y, z), cross(c, d))
    }

    private fun assertEqualsApprox(a: Float, b: Float, eps: Float = 0.0001f) {
        assertTrue(abs(a - b) < eps);
    }

    private fun assertEqualsApprox(a: Tuple, b: Tuple, eps: Float = 0.0001f) {
        assertTrue(abs(a.x - b.x) < eps);
        assertTrue(abs(a.y - b.y) < eps);
        assertTrue(abs(a.z - b.z) < eps);
        assertTrue(abs(a.w - b.w) < eps);
    }
}
