package com.duoc.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BusquedaTarjetaGrafica {
    static WebDriver driver;
    private double precio;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--no-default-browser-check");
        options.addArguments("--disable-infobars");
        options.addArguments("--user-data-dir=/tmp/chrome-test-profile");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("al navegar hasta la url {string}")
    public void al_navegar_hasta_la_url(String url) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver.get(url);
        // Thread.sleep(5000);
    }

    @When("coloco en el campo de busqueda {string} el valor de {string}")
    public void coloco_en_el_campo_de_busqueda_el_valor_de(String xpath, String textoBusqueda) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath(xpath)).click();
        driver.findElement(By.xpath(xpath)).clear();
        driver.findElement(By.xpath(xpath)).sendKeys(textoBusqueda);
        Thread.sleep(2000);
        // driver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
        // Thread.sleep(2000);
    }

    @When("debo realizar un clic en el resultado {string}")
    public void debo_realizar_un_clic_en_el_resultado(String string) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath(string)).click();

    }

    @When("obtengo el precio de la tarjeta en {string}")
    public void obtengo_el_precio_de_la_tarjeta_en(String xpath) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        this.precio = Double.parseDouble(driver.findElement(By.xpath(xpath)).getText().replace("$", "").replace(".", ""));

    }

    @Then("el ingreso a la pagina web a sido existoso")
    public void el_ingreso_a_la_pagina_web_a_sido_existoso() {
        // Write code here that turns the phrase above into concrete actions
        if (this.precio > 1000000){
            System.out.println("El precio esta muy alto no me dejaran comprarla");
        }else{
            System.out.println("Compro la tarjeta grafica");
        }
    }

}
