package com.sacombank.payment.domain.service;

import com.sacombank.payment.domain.producer.IPaymentEventProducer;
import com.sacombank.payment.domain.repository.IPaymentRepository;
import com.sacombank.payment.domain.PaymentEvent;

import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Component;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Metrics;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.extension.annotations.WithSpan;

@Component
public class PaymentFailOverService implements IPaymentFailOverService {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(PaymentFailOverService.class);

    private IPaymentRepository paymentRepository;
    private IPaymentEventProducer paymentEventProducer;

    public PaymentFailOverService(IPaymentRepository paymentRepository, IPaymentEventProducer paymentEventProducer) {
        this.paymentRepository = paymentRepository;
        this.paymentEventProducer = paymentEventProducer;
    }

    @Timed(value = "payment.event.tracking", description = "Time to process a payment event tracking")
    @WithSpan
    @Override
    public void observe(PaymentEvent paymentEvent) {
        // observe payment event via cache/database in a duration
        logger.debug("{} starts watching on result", paymentEvent.getInfo());
    }
}
