package com.example.sqch10ex5.controllers;

import com.example.sqch10ex5.exceptions.NotEnoughMoneyException;
import com.example.sqch10ex5.model.ErrorDetails;
import com.example.sqch10ex5.model.PaymentDetails;
import com.example.sqch10ex5.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment() {
            PaymentDetails paymentDetails = paymentService.processPayment();

            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);

    }
}
