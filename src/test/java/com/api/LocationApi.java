package com.api;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LocationApi {

    @Test
    public void getLocation(){
        Response response = given()
                .queryParam("q", "Hyderabad")
                .queryParam("format", "jsonv2")
                .header("User-Agent", "RestAssured-Test")
                .when()
                .get("https://nominatim.openstreetmap.org/search")
                .then()
                .extract()
                .response();

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200);

        String displayName =
                response.jsonPath().getString("[0].display_name");

        System.out.println("Location: " + displayName);

        Assert.assertTrue(displayName.contains("Hyderabad"));

    }
}
