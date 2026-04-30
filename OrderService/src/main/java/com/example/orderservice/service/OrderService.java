package com.example.orderservice.service;

import com.example.orderservice.client.KafkaProducerClient;
import com.example.orderservice.client.UserClient;
import com.example.orderservice.dto.EmailDto;
import com.example.orderservice.dto.OrderRequestDto;
import com.example.orderservice.dto.OrderResponseDto;
import com.example.orderservice.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import com.example.orderservice.repo.OrderRepository;
import com.example.orderservice.models.Order;
import com.example.orderservice.models.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserClient userClient;
    @Autowired
    private KafkaProducerClient kafkaProducerClient;
    @Autowired
    private ObjectMapper objectMapper;


    public OrderResponseDto createOrder(OrderRequestDto request) {
        // 1. Call User Service
        UserDto user = userClient.getUserById(request.getUserId());

        if (user == null) {
            throw new RuntimeException("User not found");
        }
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setProductName(request.getProductName());
        order.setPrice(request.getPrice());
        order.setQuantity(request.getQuantity());
        order.setStatus(OrderStatus.CREATED);

        orderRepository.save(order);
        try {
            EmailDto emailDto = new EmailDto();
            emailDto.setTo(user.getEmail());
            emailDto.setFrom("sahithya.12ks@gmail.com");
            emailDto.setSubject("Order status");
            emailDto.setBody("Your Order Is Placed Thank You For Ordering");

            kafkaProducerClient.sendMessage("createOrder", objectMapper.writeValueAsString(emailDto));
        }catch (JsonProcessingException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return new OrderResponseDto(order.getId(), "Order Created Successfully");
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
