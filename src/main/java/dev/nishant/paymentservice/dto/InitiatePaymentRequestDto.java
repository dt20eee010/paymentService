package dev.nishant.paymentservice.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentRequestDto {
    private String email;
    private String phoneNumber;
    private Long amount;
    private String orderId;
}
