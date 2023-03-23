package com.swagger.api.controller;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class BaseController {
    public RequestSpecification petStoreApiClient(String basePath) {
        return given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath(basePath)
                .log().everything()
                .contentType(ContentType.JSON);
    }
}
