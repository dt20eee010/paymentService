package dev.nishant.paymentservice.service;

import com.razorpay.RazorpayException;

public interface PaymentService {

    String doPayment(String email, String phoneNumber, Long amount,String orderId) throws RazorpayException;
}
