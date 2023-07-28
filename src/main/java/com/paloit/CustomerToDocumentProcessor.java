package com.paloit;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.bson.Document;

public class CustomerToDocumentProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Customer customer = exchange.getIn().getBody(Customer.class);

        Document document = new Document();
        document.put("firstName", customer.getFirstName());
        document.put("lastName", customer.getLastName());

        exchange.getIn().setBody(document);
    }
}
