package com.curso.microservicios.currencyexchangeservice;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController{
	
	@Autowired
    private Environment environment;
    
    @Autowired
    private ExchangeValueRepository repository;
    
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue
        (@PathVariable String from, @PathVariable String to){
        
        ExchangeValue exchangeValue =
                repository.findByFromAndTo(from, to);
        
        exchangeValue.setPort(
                Integer.parseInt(environment.getProperty("local.server.port")));
        
        return exchangeValue;
    }

	

}
