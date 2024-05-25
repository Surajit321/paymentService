package com.example.paymentService.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Primary
public class StripePayment implements PaymentGateWay{

    @Value("${stripe.key}")
    private String key;
    @Override
    public String generatePaymentLink(String order_id, Long amount, String phoneNo, String email) throws StripeException {
        Stripe.apiKey = this.key;

//        PaymentLinkCreateParams params =
//                PaymentLinkCreateParams.builder()
//                        .addLineItem(
//                                PaymentLinkCreateParams.LineItem.builder()
//                                        .setPrice("price_1MoC3TLkdIwHu7ixcIbKelAC")
//                                        .setQuantity(1L)
//                                        .build()
//                        )
//                        .build();

        Map<String, Object> priceParams = new HashMap<>();
        priceParams.put("unit_amount", amount);
        priceParams.put("currency", "INR");

        Map<String, Object> productData = new HashMap<>();
        productData.put("name", "Iphone");

        priceParams.put("product_data", productData);

        Price price = Price.create(priceParams);

        Map<String, Object> lineItem1 = new HashMap<>();
        lineItem1.put("price", price.getId());
        lineItem1.put("quantity", 1);

        Map<String, Object> afterPayment = new HashMap<>();
        afterPayment.put("type", "redirect");

        Map<String, Object> redirect = new HashMap<>();
        redirect.put("url", "https://scaler.com/");

        afterPayment.put("redirect", redirect);

        List<Object> lineItems = new ArrayList<>();
        lineItems.add(lineItem1);

        Map<String, Object> params = new HashMap<>();
        params.put("line_items", lineItems);
        params.put("after_completion", afterPayment);

        PaymentLink paymentLink = PaymentLink.create(params);

        return paymentLink.toString();
    }
}
