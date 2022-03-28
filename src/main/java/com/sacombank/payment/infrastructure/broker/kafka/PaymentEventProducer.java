package com.sacombank.payment.infrastructure.broker.kafka;

import com.sacombank.payment.domain.PaymentEvent;
import com.sacombank.payment.domain.producer.IPaymentEventProducer;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Component
public class PaymentEventProducer implements IPaymentEventProducer {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(PaymentEventProducer.class);

    @Autowired
    private KafkaTemplate<String, PaymentEvent> PaymentEventKafkaTemplate;

    @Value(value = "${kafka.payment.orchestrate}")
    private String orchestrateTopicName;

    @Override
    public void publish(PaymentEvent PaymentEvent) {
        ListenableFuture<SendResult<String, PaymentEvent>> future = PaymentEventKafkaTemplate.send(orchestrateTopicName, PaymentEvent);

            future.addCallback(new ListenableFutureCallback<SendResult<String, PaymentEvent>>() {

                @Override
                public void onSuccess(SendResult<String, PaymentEvent> result) {
                   logger.debug("Sent message=[" + PaymentEvent.getEventId() + "] with offset=[" + result.getRecordMetadata()
                        .offset() + "]");
                }

                @Override
                public void onFailure(Throwable ex) {
                    logger.debug("Unable to send message=[" + PaymentEvent.getEventId() + "] due to : " + ex.getMessage());
                }
            });
        
    }

    @Override
    public void publish(String topic, PaymentEvent PaymentEvent) {
        ListenableFuture<SendResult<String, PaymentEvent>> future = PaymentEventKafkaTemplate.send(topic, PaymentEvent);

            future.addCallback(new ListenableFutureCallback<SendResult<String, PaymentEvent>>() {

                @Override
                public void onSuccess(SendResult<String, PaymentEvent> result) {
                   logger.debug("Sent message=[" + PaymentEvent.getEventId() + "] with offset=[" + result.getRecordMetadata()
                        .offset() + "]");
                }

                @Override
                public void onFailure(Throwable ex) {
                    logger.debug("Unable to send message=[" + PaymentEvent.getEventId() + "] due to : " + ex.getMessage());
                }
            });
        
    }
}
