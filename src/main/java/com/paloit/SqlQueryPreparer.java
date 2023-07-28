package com.paloit;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class SqlQueryPreparer implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Customer customer = exchange.getProperty(AppConfig.CUSTOMER_PROPERTY, Customer.class);
        String query = "INSERT INTO customers(first_name, last_name) VALUES('"
                + customer.getFirstName() + "','" + customer.getLastName() + "')";
        exchange.getIn().setBody(query);
    }
}
