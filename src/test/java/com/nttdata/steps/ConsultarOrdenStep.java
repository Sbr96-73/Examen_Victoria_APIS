package com.nttdata.steps;

import com.nttdata.model.Orden;
import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConsultarOrdenStep {

    private String BASE_URL = "https://petstore.swagger.io/v2/store/order";

    public Orden orden;


    public void consultarOrden(int id) {
        Response response = given()
                .baseUri(BASE_URL)
                .log().all()
                .when()
                .get("/" + id);

        if (response.statusCode() == 200) {
            orden = response.as(Orden.class);
            listarOrden(orden);
        } else if (response.statusCode() == 404) {
            System.out.println("Orden no encontrada para petId: " + id);
        }
    }

    public void listarOrden(Orden orden) {
        System.out.println("@@@@@@@@@@");
        System.out.println("Id: " + orden.getId());
        System.out.println("Id Mascota: " + orden.getPetId());
        System.out.println("Cantidad: " + orden.getQuantity());
        System.out.println("Fecha: " + orden.getShipDate());
        System.out.println("Status: " + orden.getStatus());
        System.out.println("Complete: " + orden.getComplete());
        System.out.println("@@@@@@@@@@");
    }

    public void validarCodigoRespuesta(int statusCode) {
        assertThat(lastResponse().statusCode(), is(statusCode));
    }
}



