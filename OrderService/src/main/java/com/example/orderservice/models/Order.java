package com.example.orderservice.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "orders")
@Data
public class Order extends BaseModel {

    private Long userId;
    private String productName;
    private Double price;
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
