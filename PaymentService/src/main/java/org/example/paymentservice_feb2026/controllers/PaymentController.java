package org.example.paymentservice_feb2026.controllers;

import org.example.paymentservice_feb2026.dtos.PaymentLinkRequestDto;
import org.example.paymentservice_feb2026.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public String getPaymentLink(@RequestBody PaymentLinkRequestDto paymentLinkRequestDto) {
      return paymentService.getPaymentLink(paymentLinkRequestDto.getAmount(),paymentLinkRequestDto.getOrderId(),paymentLinkRequestDto.getPhoneNumber(),paymentLinkRequestDto.getName());
    }
}
       // Long amount,String orderId, String phoneNumber, String name