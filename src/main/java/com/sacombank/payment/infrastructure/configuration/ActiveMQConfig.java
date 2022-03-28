package com.sacombank.payment.infrastructure.configuration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@EnableJms
@Configuration
public class ActiveMQConfig {

    @Value(value = "${activemq.broker}")
    private String broker;

    @Value(value = "${activemq.username}")
    private String username;

    @Value(value = "${activemq.password}")
    private String password;

	@Bean
	public ActiveMQConnectionFactory connectionFactory(){
	    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
	    connectionFactory.setBrokerURL(broker);
	    connectionFactory.setPassword(password);
	    connectionFactory.setUserName(username);
	    return connectionFactory;
	}

	@Bean
	public JmsTemplate jmsTemplate(){
	    JmsTemplate template = new JmsTemplate();
	    template.setConnectionFactory(connectionFactory());
        template.setMessageConverter(messageConverter());
	    return template;
	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
	    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	    factory.setConnectionFactory(connectionFactory());
        factory.setMessageConverter(messageConverter());
	    factory.setConcurrency("1-1");
	    return factory;
	}

    @Bean
    public MessageConverter messageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
