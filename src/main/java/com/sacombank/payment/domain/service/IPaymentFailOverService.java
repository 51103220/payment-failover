package com.sacombank.payment.domain.service;
import com.sacombank.payment.domain.PaymentEvent;


public interface IPaymentFailOverService {
    void observe(PaymentEvent paymentEvent);
}
