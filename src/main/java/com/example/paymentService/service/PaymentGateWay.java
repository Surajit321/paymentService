package com.example.paymentService.service;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Component;

public interface PaymentGateWay {
    String generatePaymentLink(String order_id, Long amount, String phoneNo, String email) throws RazorpayException, StripeException;
}
