package org.example.paymentservice_feb2026.dtos;

import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public class PaymentLinkRequestDto {
    Long amount;
    String orderId;
    String phoneNumber;
    String name;
}
