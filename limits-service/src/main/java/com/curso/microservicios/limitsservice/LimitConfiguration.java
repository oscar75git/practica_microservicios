package com.curso.microservicios.limitsservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LimitConfiguration {
	
	private int maximum;
    private int minimum;
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    protected LimitConfiguration() {

    }

    public LimitConfiguration(int maximum, int minimum) {
        super();
        
        logger.info("{}", minimum);
        logger.info("{}", maximum);
        
        this.maximum = maximum;
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public int getMinimum() {
        return minimum;
    }


}
