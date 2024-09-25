package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtils {

    public static Response getRequest(String endpoint) {
        return RestAssured.given()
                .baseUri("https://automationexercise.com/api")  // Base URI da API
                .get(endpoint);
    }
}
