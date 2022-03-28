package com.sacombank.payment.domain.producer;

import com.sacombank.payment.domain.PaymentEvent;

public interface IPaymentTracingProducer {
    public void publish(String topic, PaymentEvent paymentEvent);
}
