package dev.nishant.paymentservice.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentGatewaySelectionService implements PaymentGatewaySelectionStrategy{
    @Override
    public int paymentGatewaySelection() {
        double randomDouble = Math.random();
        // Map the random double to the desired range (1 to 2)
        int randomNumber = (int) (randomDouble * 2) + 1;
        return randomNumber;
    }
}
