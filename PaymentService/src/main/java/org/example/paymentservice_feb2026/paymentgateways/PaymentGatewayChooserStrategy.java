package org.example.paymentservice_feb2026.paymentgateways;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayChooserStrategy {

    @Autowired
    private RazorpayPaymentGateway razorpayPaymentGateway;

    @Autowired
    private StripePaymentGateway stripePaymentGateway;

    public IPaymentGateway getBestPaymentGateway() {
       // We can have integration with Metrics Service
       // which will give us success/failure of payment gateways
       // of last 3 hors and based on that, we can choose payment gateway
       return stripePaymentGateway;
    }
}
