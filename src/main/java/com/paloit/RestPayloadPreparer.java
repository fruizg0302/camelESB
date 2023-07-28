package com.paloit;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.HashMap;
import java.util.Map;

public class RestPayloadPreparer implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Customer customer = exchange.getProperty(AppConfig.CUSTOMER_PROPERTY, Customer.class);
        Map<String, Object> customerMap = new HashMap<>();
        customerMap.put("first_name", customer.getFirstName());
        customerMap.put("last_name", customer.getLastName());
        exchange.getIn().setBody(customerMap);
    }
}
