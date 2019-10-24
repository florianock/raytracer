package raytracer

import cucumber.api.PendingException
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java8.En
import junit.framework.Assert.assertEquals

class StepDefs: En {
    private lateinit var a: Tuple

    @Given("a <- tuple\\({double}, {double}, {double}, {double})")
    fun initializeTupleA(x: Double, y: Double, z: Double, w: Double) {
        a = Tuple(x, y, z, w)
    }

    @Then("a.x = {double}")
    fun tupleAFieldXIsX(x: Double){
        assertEquals(x, a.x)
    }

    @Then("a.y = {double}")
    fun tupleAFieldYIsY(y: Double){
        assertEquals(y, a.y)
    }

    @Then("a.z = {double}")
    fun tupleAFieldZIsZ(z: Double){
        assertEquals(z, a.z)
    }

    @Then("a.w = {double}")
    fun tupleAFieldWIsW(w: Double){
        assertEquals(w, a.w)
    }

    @Then("a is a Point")
    fun aIsAPoint() {
        assertEquals(a.w, 1)
    }

//    @Then("a.w = {double}")
//    fun tupleAFieldWIsW(w: Double){
//        a.w == w
//    }
}