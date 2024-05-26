package com.example.paymentService.controller;

import com.stripe.model.Event;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhooks")
public class StripeWebhookController {

    @PostMapping
    public void stripeWebHook(@RequestBody Event event){

        if(event.getType()=="charge.succeeded"){
            System.out.println("Payment success. Continue shopping?");
        }
    }

}
