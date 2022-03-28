package com.sacombank.payment.application;

import com.sacombank.payment.domain.PaymentEvent;
import com.sacombank.payment.domain.service.IPaymentFailOverService;

import javax.jms.JMSException;
import javax.jms.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;

@Component
public class PaymentActiveMQListener {
    private final IPaymentFailOverService paymentService;
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(PaymentActiveMQListener.class);

    public PaymentActiveMQListener(IPaymentFailOverService paymentService) {
        this.paymentService = paymentService;
    }

    @JmsListener(destination = "${activemq.payment.event.tracking}")
	public void paymentServe(final @Payload PaymentEvent paymentEvent) throws JMSException {
        logger.debug("{} received payment tracking request", paymentEvent.getInfo());
        paymentService.observe(paymentEvent);
	}
}
