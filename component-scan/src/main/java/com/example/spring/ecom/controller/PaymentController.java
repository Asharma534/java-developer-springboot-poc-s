package com.example.spring.ecom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController{

    @GetMapping(value = "/makepayment")
    public String makePayment() {
        return  "payment done";
    }
}
