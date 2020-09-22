package org.j4k.workshops.quarkus.infrastucture;

import java.util.UUID;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;;

@QuarkusTest
public class FavFoodResourceTest {

    @Test
    public void testFavFoodEndpoint() {

        final JsonObject order = mockOrder();

        System.out.println(order.toString());

        given()
          .accept(MediaType.APPLICATION_JSON)
          .contentType(MediaType.APPLICATION_JSON)
          .body(order.toString())
          .when()
          .post("/FavFood")
          .then()
             .statusCode(202)
             .body("orderId", equalTo(order.getString("orderId")))
             .body("customerName", equalTo("Lemmy"));
    }

    JsonObject mockOrder(){
        return Json.createObjectBuilder()
        .add("customerName", "Lemmy")
        .add("orderId", UUID.randomUUID().toString())
        .add("lineItems", mockLineItems()).build();    
    }

	private JsonArray mockLineItems() {
        final JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        arrayBuilder.add(mockLineItem());
		return arrayBuilder.build();
	}

	private JsonObject mockLineItem() {
        return Json.createObjectBuilder()
        .add("item", "BLACK_COFFEE")
        .add("id", UUID.randomUUID().toString())
        .add("quantity", 1).build();    
	}

}
