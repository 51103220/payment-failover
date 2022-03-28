package com.sacombank.payment.domain.producer;

import com.sacombank.payment.domain.PaymentEvent;

public interface IPaymentEventProducer {
    public void publish(PaymentEvent paymentEvent);
    public void publish(String topic, PaymentEvent paymentEvent);

}
