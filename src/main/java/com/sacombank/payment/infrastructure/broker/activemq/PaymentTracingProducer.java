package com.sacombank.payment.infrastructure.broker.activemq;

import com.sacombank.payment.domain.PaymentEvent;
import com.sacombank.payment.domain.producer.IPaymentTracingProducer;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentTracingProducer implements IPaymentTracingProducer {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(PaymentTracingProducer.class);

    @Autowired
	JmsTemplate jmsTemplate;

    
    @Override
    public void publish(String topic, PaymentEvent paymentEvent) {      
        jmsTemplate.convertAndSend(topic, paymentEvent);  
        logger.debug("send msg " + paymentEvent.getEventId() + " ");
    }
}
