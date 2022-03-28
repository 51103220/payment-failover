package com.sacombank.payment.infrastructure.configuration;

import javax.annotation.PreDestroy;

import com.sacombank.payment.domain.repository.IPaymentRepository;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements ApplicationRunner {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Initializer.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("application is ready to serve...");       
    }

    @Bean
	InitializingBean populateData() {
		return () -> {
            // load data from DB
            logger.info("populated data");
		};
	}
    
    @PreDestroy
    public void onExit() {
        logger.info("application stopped");
    }
    
}
