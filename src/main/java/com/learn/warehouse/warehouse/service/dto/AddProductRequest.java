package com.learn.warehouse.warehouse.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddProductRequest {
    private String name;
    private String description;
    private String type;
    private int price;
    private int quantity;
}
