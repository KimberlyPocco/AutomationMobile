package com.qalab.stepsdefinitions;
import com.qalab.steps.AgregarCarritoSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class AgregarCarritoSD {
    @Steps
    AgregarCarritoSteps agregarCarritoSteps;

    @Given("estoy en la aplicacion SauceLabs")
    public void estoyEnLaAplicacionSauceLabs() {
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        agregarCarritoSteps.verificarProductosEnGaleria();
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agregoDelSiguienteProducto(int unidades, String producto) {
        agregarCarritoSteps.agregarProductoAlCarrito(unidades,producto );
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        agregarCarritoSteps.validarCarritoCompraActualice();
    }

}
