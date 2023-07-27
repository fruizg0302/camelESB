package com.paloit;

import org.apache.camel.builder.RouteBuilder;

public class RestToRestRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().component("servlet");

        from("rest:get:/input")
                .log("Received REST request")
                .process(exchange -> {
                    String body = exchange.getIn().getBody(String.class);
                    // Process the request body as needed
                })
                .to("mongodb:mongoBean?database=test&collection=test&operation=insert")
                .to("http://other.rest.service/output")
                .log("Sent REST response");
    }
}

