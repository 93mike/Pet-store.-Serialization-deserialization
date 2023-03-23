package com.swagger.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    private Integer petId;
    private Integer quantity;
    private Integer id;
    private String shipDate;
    private Boolean complete;
    private String status;
}