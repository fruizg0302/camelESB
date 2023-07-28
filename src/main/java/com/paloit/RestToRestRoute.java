package com.paloit;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import java.util.HashMap;
import java.util.Map;

public class RestToRestRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().component("spark-rest").contextPath("/api").host("localhost").port(8080);

        from("spark-rest:post:/api/input")
                .unmarshal().json(JsonLibrary.Jackson, Customer.class)
                .setProperty("customer", body()) // save the Customer object in a property
                .process(new CustomerToDocumentProcessor())
                .to("mongodb:myDb?database=test&collection=test&operation=insert&connectionBean=mongoBean")
                .process(exchange -> {
                    Customer customer = exchange.getProperty("customer", Customer.class);
                    String query = "INSERT INTO customers(first_name, last_name) VALUES('"
                            + customer.getFirstName() + "','" + customer.getLastName() + "')";
                    exchange.getIn().setBody(query);
                })
                .to("jdbc:myDataSource")
                .process(exchange -> {
                    Customer customer = exchange.getProperty("customer", Customer.class);
                    Map<String, Object> customerMap = new HashMap<>();
                    customerMap.put("first_name", customer.getFirstName());
                    customerMap.put("last_name", customer.getLastName());
                    exchange.getIn().setBody(customerMap);
                })
                .marshal().json(JsonLibrary.Jackson)
                .to("http://localhost:3000/customers?bridgeEndpoint=true")
                .log("Sent REST response");

    }
}
