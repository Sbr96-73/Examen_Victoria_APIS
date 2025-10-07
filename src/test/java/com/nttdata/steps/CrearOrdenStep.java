package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;
import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearOrdenStep {

    private String CREATE_ORDER = "https://petstore.swagger.io/v2/store/order";

    public void crearOrden(int id,int petId, int quantity, String shipDate){
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": "+id+",\n" +
                        "  \"petId\": "+petId+",\n" +
                        "  \"quantity\": "+quantity+",\n" +
                        "  \"shipDate\": \""+shipDate+"\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .log().all()
                .post(CREATE_ORDER)
                .then()
                .log().all();
    }

    public void validarCodigoRespuesta(int statusCode) {

        restAssuredThat(response -> response.statusCode(statusCode));
    }


    public void validarIdYStatus(int id, String status){
        restAssuredThat(resp -> resp.body("id", equalTo(id)));
        restAssuredThat(resp -> resp.body("status", equalTo(status)));
    }

}


