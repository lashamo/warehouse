package com.learn.warehouse.warehouse.service.dto;

import com.learn.warehouse.warehouse.entity.ProductType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class UpdateRequest {
    private Long id;
    private  int quantity;
}
