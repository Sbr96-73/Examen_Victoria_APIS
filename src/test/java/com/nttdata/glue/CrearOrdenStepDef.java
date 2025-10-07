package com.nttdata.glue;

import com.nttdata.steps.CrearOrdenStep;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearOrdenStepDef {

    @Steps
    CrearOrdenStep crearOrden;

    @Given("estoy en el formulario")
    public void estoyEnElFormulario() {

    }


    @When("creo la orden con id {int} Mascota {int}, con cantidad {int} y fecha {string}")
    public void creoLaOrden(int id, int petId, int quantity, String shipDate) {
        crearOrden.crearOrden(id, petId, quantity, shipDate);
    }


    @Then("el sistema me da como respuesta {int}")
    public void elSistemaMeDaComoRespuesta(int statusCode) {
        crearOrden.validarCodigoRespuesta(statusCode);
    }

    @And("la orden muestra el id {int} y status {string}")
    public void laOrdenMuestraElIdYStatusCorrectos(int id, String status) {

        crearOrden.validarIdYStatus(id, status);
    }
}
