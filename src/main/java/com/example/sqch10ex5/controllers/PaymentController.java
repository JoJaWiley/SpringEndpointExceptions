package com.example.sqch10ex5.controllers;

import com.example.sqch10ex5.exceptions.NotEnoughMoneyException;
import com.example.sqch10ex5.model.ErrorDetails;
import com.example.sqch10ex5.model.PaymentDetails;
import com.example.sqch10ex5.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentController {

    private static Logger logger = Logger.getLogger(PaymentController.class.getName());
    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment(@RequestBody PaymentDetails paymentDetails) {

        logger.info("Received payment " + paymentDetails.getAmount());

            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);
    }
}
