package com.example.paymentService.service;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGateWay paymentGateWay;
    PaymentService(PaymentGateWay paymentGateWay){
        this.paymentGateWay = paymentGateWay;
    }

    public String initiatePayment(String order_id, Long amount, String phoneNo, String email) throws StripeException, RazorpayException {
        return this.paymentGateWay.generatePaymentLink(order_id, amount, phoneNo, email);
    }
}
