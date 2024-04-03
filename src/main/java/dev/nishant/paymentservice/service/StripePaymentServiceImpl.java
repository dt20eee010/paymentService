package dev.nishant.paymentservice.service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("Stripe")
public class StripePaymentServiceImpl implements PaymentService{

    @Override
    public String doPayment(String email, String phoneNumber, Long amount, String orderId) {
        return null;
    }
}
