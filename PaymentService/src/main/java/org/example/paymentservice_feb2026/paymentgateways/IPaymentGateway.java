package org.example.paymentservice_feb2026.paymentgateways;

public interface IPaymentGateway {
    String getPaymentLink(Long amount,String orderId, String phoneNumber, String name);
}
