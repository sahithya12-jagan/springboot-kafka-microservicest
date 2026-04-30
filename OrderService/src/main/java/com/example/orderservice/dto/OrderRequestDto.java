package com.example.orderservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {
    private Long userId;
    private String productName;
    private Double price;
    private Integer quantity;
}
