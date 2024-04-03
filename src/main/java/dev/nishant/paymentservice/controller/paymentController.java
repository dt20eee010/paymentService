package dev.nishant.paymentservice.controller;

import com.razorpay.RazorpayException;
import dev.nishant.paymentservice.dto.InitiatePaymentRequestDto;
import dev.nishant.paymentservice.service.PaymentGatewaySelectionStrategy;
import dev.nishant.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class paymentController {
    private PaymentService RazorpaymentService;
    private PaymentService StripepaymentService;

    private PaymentGatewaySelectionStrategy paymentGatewaySelectionStrategy;

    public paymentController(@Qualifier("RazorPay") PaymentService RazorpaymentService, @Qualifier("Stripe") PaymentService stripepaymentService,PaymentGatewaySelectionStrategy paymentGatewaySelectionStrategy ) {
        this.RazorpaymentService = RazorpaymentService;
        this.StripepaymentService = stripepaymentService;
        this.paymentGatewaySelectionStrategy=paymentGatewaySelectionStrategy;
    }

    @PostMapping("/payment")
    public String inititatePayment(@RequestBody InitiatePaymentRequestDto requestDto) throws RazorpayException {
        int paymentGatewayOption = paymentGatewaySelectionStrategy.paymentGatewaySelection();
        return switch (paymentGatewayOption) {
            case 1 ->
                    RazorpaymentService.doPayment(requestDto.getEmail(), requestDto.getPhoneNumber(), requestDto.getAmount(), requestDto.getOrderId());
            case 2 ->
                    StripepaymentService.doPayment(requestDto.getEmail(), requestDto.getPhoneNumber(), requestDto.getAmount(), requestDto.getOrderId());
            default -> null;
        };
    }

}
