package com.example.paymentService.controller;

import com.example.paymentService.dto.InitialPaymentRequestDto;
import com.example.paymentService.service.PaymentService;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    PaymentService paymentService;

    PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String initiatePayment(@RequestBody() InitialPaymentRequestDto initialPaymentRequestDto) throws StripeException, RazorpayException {
        return paymentService.initiatePayment(initialPaymentRequestDto.getOrder_id(), initialPaymentRequestDto.getAmount(),
                initialPaymentRequestDto.getPhoneNo(), initialPaymentRequestDto.getEmail());
    }
}
