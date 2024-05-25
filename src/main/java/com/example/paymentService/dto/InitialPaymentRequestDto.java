package com.example.paymentService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitialPaymentRequestDto {
    private String order_id;
    private Long amount;
    private String phoneNo;
    private String email;
}
