package com.swagger.api.controller;

import com.swagger.api.model.PetDto;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PetController extends BaseController {
    private RequestSpecification petApi() {
        return petStoreApiClient("/pet");
    }

    public Response addNewPetToStore(PetDto petDto) {
        return petApi()
                .body(petDto)
                .post();
    }

    public Response getPetById(long targetPetId) {
        return petApi().get("/{targetPetId}", targetPetId);
    }
}
