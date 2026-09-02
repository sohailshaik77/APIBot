package com.api;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class User {

        @Test
        public void verifyGetUser() {

            Response response = RestAssured
                    .given()
                    .baseUri("https://reqres.in")
                    .when()
                    .get("/api/users/2");

            System.out.println("Status Code : " + response.getStatusCode());
            System.out.println("Response : ");
            response.prettyPrint();

            Assert.assertEquals(response.getStatusCode(), 200);

            String firstName = response.jsonPath().getString("data.first_name");

            Assert.assertEquals(firstName, "Janet");
        }
    }

