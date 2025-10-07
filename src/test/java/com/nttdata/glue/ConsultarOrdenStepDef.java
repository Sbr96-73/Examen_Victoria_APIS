package com.nttdata.glue;

import com.nttdata.steps.ConsultarOrdenStep;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ConsultarOrdenStepDef {

    @Steps
    ConsultarOrdenStep consultaOrden;

    @Given("estoy en la pagina de Orden")
    public void estoyEnLaPaginaDeOrden() {

    }

    @When("hago la consulta de la orden con el id {int}")
    public void hagoLaConsultaDeLaOrdenConElId(int id) {
        consultaOrden.consultarOrden(id);
    }

    @Then("el sistema da como respuesta es {int}")
    public void elSistemaDaComoRespuestaEs(int statusCode) {
        consultaOrden.validarCodigoRespuesta(statusCode);

    }


}
