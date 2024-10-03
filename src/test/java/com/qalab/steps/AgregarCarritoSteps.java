package com.qalab.steps;
import com.qalab.screens.AgregarCarritoScreen;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AgregarCarritoSteps {
    AgregarCarritoScreen agregarCarritoScreen;

    public void verificarProductosEnGaleria() {
        Assert.assertTrue("Products", agregarCarritoScreen.esProductoDisplayed());
    }

    public void agregarProductoAlCarrito(int unidades, String producto) {
        agregarCarritoScreen.agregarProductoAlCarrito(unidades, producto);
    }

    public void validarCarritoCompraActualice() {
        agregarCarritoScreen.validarCarrito();

    }


}
