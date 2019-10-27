package raytracer

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java8.En
import junit.framework.TestCase.*

class StepDefs: En {
    private var world: MutableMap<String, Any> = mutableMapOf()

    @Given("^(\\w+) ← (\\w+)\\(([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+)\\)$")
    fun initializeTupleOf4(a: String, ctr: String, x: Float, y: Float, z: Float, w: Float) {
        world[a] = Tuple(x, y, z, w)
    }

    @Given("^(\\w+) ← (\\w+)\\(([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+)\\)$")
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

    @Then("^(\\w+) is([ not]+us) a (\\w+)$")
    fun testType(key: String, not: String, type: String) {
        val a = world[key] as Tuple
        when (not) {
            "" -> assertEquals(type.toLowerCase(), a.getType().toString().toLowerCase())
            " not" -> assertTrue(type.toLowerCase() != a.getType().toString().toLowerCase())
        }
    }
//
//    @Then("^(\\w+) is a (\\w+)$")
//    fun aIsAType(key: String, type: String) {
//        val a = world[key] as Tuple
//        assertEquals(type.toLowerCase(), a.getType().toString().toLowerCase())
//    }

    @Then("(\\w+) = tuple\\(([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+), ([-+]?[0-9]*\\.?[0-9]+)\\)")
    fun pEqualsTuple(key: String, x: Float, y: Float, z: Float, w: Float) {
        val p = world[key] as Tuple
        assertEquals(Tuple(x, y, z, w), p)
    }
}
