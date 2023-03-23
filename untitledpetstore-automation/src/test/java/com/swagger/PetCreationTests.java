package com.swagger;

import com.github.javafaker.Faker;
import com.swagger.api.controller.PetController;
import com.swagger.api.model.PetDto;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class PetCreationTests {
    static {
        requestSpecification = new RequestSpecBuilder().log(LogDetail.ALL).build();
        responseSpecification = new ResponseSpecBuilder().log(LogDetail.ALL).build();
    }

    Faker faker = new Faker();
    PetController petController = new PetController();

    @Test
    @DisplayName("creation new pet via API")
    void creationOfANewPetViaPpi() {
        String targetPetName = faker.name().name();
        PetDto targetPet = PetDto.builder().name(targetPetName).id(faker.number().randomNumber()).build();

        var createdPetResponce = petController
                .addNewPetToStore(targetPet);

        Assertions.assertEquals(200, createdPetResponce.statusCode());
        Response petByIdResponce = petController.getPetById(targetPet.getId());

        PetDto actualPet = petByIdResponce.as(PetDto.class);
        Assertions.assertEquals(targetPetName, actualPet.getName());
        Assertions.assertEquals(200, petByIdResponce.statusCode());
    }
}
