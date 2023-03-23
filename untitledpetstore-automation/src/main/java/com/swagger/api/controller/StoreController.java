package com.swagger.api.controller;

import com.swagger.api.model.OrderDto;
import io.restassured.response.Response;

public class StoreController extends BaseController {
    public Response createOrder (OrderDto targetOrder){
        return petStoreApiClient("store")
                .body(targetOrder)
                .post("/order");
    }
}
