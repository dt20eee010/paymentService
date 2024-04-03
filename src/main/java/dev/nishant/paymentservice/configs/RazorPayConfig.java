package dev.nishant.paymentservice.configs;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorPayConfig {
    @Value("${razorpay.key.id}")// this is fetch information from application. properties file and update these values
    private String RazorPayKeyId;
    @Value("${razorpay.key.secret}")// this is fetch information from application. properties file and update these values
    private String RazorPayKeySecret;
    @Bean
    public RazorpayClient createRazorpayClient() throws RazorpayException {
        return new RazorpayClient(RazorPayKeyId,RazorPayKeySecret);
    }
}
