package dev.nishant.paymentservice.service;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Qualifier("RazorPay")
@Service
public class RazorPayPaymentServiceImpl implements PaymentService{

    private RazorpayClient razorpayClient;

    public RazorPayPaymentServiceImpl(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String doPayment(String email, String phoneNumber, Long amount,String orderId) throws RazorpayException {
        try {
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", 50000);
            paymentLinkRequest.put("currency", "INR");
            paymentLinkRequest.put("receipt", "receipt#1");
            JSONObject customer = new JSONObject();
            customer.put("email", email);
            customer.put("phone", phoneNumber);
            paymentLinkRequest.put("customer", customer);
            JSONObject notify = new JSONObject();
            notify.put("sms", true);
            notify.put("email", true);
            paymentLinkRequest.put("notify", notify);
            paymentLinkRequest.put("callback_url", "https://domain.com/razorpayWebhook");
            paymentLinkRequest.put("callback_method", "post");
            PaymentLink response = razorpayClient.paymentLink.create(paymentLinkRequest);
            return response.toString();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
