package com.qalab.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AgregarCarritoScreen extends  PageObject{

        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/productTV\"]\n")
        private WebElement lblProduct;

        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/noTV\"]]")
        private WebElement inputUnidad;

        @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Increase item quantity']")
        private WebElement btnMas;

        @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Tap to add product to cart']")
        private WebElement btnAnadirCarrito;

        @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Displays number of items in your cart']")
        private WebElement btnVerificarCarrito;


        public boolean esProductoDisplayed(){
            waitFor(ExpectedConditions.visibilityOf(lblProduct));
            return lblProduct.isDisplayed();
        }

        public void seleccionarProducto(String productoNombre) {
            String nombreProductoXpath = "//android.widget.ImageView[@content-desc='" + productoNombre + "']";
            WebElement producto = getDriver().findElement(By.xpath(nombreProductoXpath));
            waitFor(ExpectedConditions.visibilityOf(producto));
            producto.click();
        }

        public int obtenerCantidadActual() {
            try {
                String cantidadTexto = inputUnidad.getText();
                return Integer.parseInt(cantidadTexto);
             } catch (Exception e) {
                return 1;
            }
        }

        public void agregarUnidades(int unidadesProducto) {
            String unidadesProductoXpath = "//android.widget.TextView[@text='" + String.valueOf(unidadesProducto) + "']";
            int cantidadActual = obtenerCantidadActual();

            try {
                WebElement unidades = getDriver().findElement(By.xpath(unidadesProductoXpath));
                waitFor(ExpectedConditions.visibilityOf(unidades));

                if (unidadesProducto > cantidadActual) {
                        for (int i = 0; i < (unidadesProducto - cantidadActual); i++) {
                            waitFor(ExpectedConditions.elementToBeClickable(btnMas));
                            btnMas.click();
                        }
                }
            } catch (NoSuchElementException e) {
                System.out.println("La cantidad de unidades deseadas no se encontraron");
            }
        }

        public void anadirProductoAlCarrito() {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(btnAnadirCarrito));
            btnAnadirCarrito.click();
        }

        public void agregarProductoAlCarrito(int unidades, String productoNombre) {
            seleccionarProducto(productoNombre);
            agregarUnidades(unidades);
            anadirProductoAlCarrito();
        }

        public void validarCarrito() {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(btnVerificarCarrito));
            btnVerificarCarrito.click();
        }

}
