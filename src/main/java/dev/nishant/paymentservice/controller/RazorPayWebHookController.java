package dev.nishant.paymentservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/razorpayWebHook")
public class RazorPayWebHookController {

    @PostMapping("/payments")
    public ResponseEntity acceptWebHookRequest(){
        // redirect to UI
        return null;
    }
}
