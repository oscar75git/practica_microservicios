package com.curso.microservicios.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {


    @Autowired
    private Configuration configuration;
    
    @Autowired
    //private RabbitMQSender sender;

    @GetMapping("/limits")
    public Configuration retrieveLimitsFromConfigurations() {
    	
    	//sender.send(configuration);
    	
    	return new Configuration(configuration.getMaximum(),
                configuration.getMinimum());
    }
    
    @GetMapping("/fault-tolerance-example")
    @HystrixCommand(fallbackMethod="fallbackRetrieveConfiguration")
    public Configuration retrieveConfiguration() {
        throw new RuntimeException("Not available");
    }

    
    public Configuration fallbackRetrieveConfiguration() {
        return new Configuration(123, 1);
    }


}
