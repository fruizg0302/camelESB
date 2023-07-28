package com.paloit;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

public class RestToRestRoute extends RouteBuilder {

    private final SqlQueryPreparer sqlQueryPreparer;
    private final RestPayloadPreparer restPayloadPreparer;

    public RestToRestRoute() {
        this.sqlQueryPreparer = new SqlQueryPreparer();
        this.restPayloadPreparer = new RestPayloadPreparer();
    }

    @Override
    public void configure() throws Exception {
        restConfiguration().component(AppConfig.SPARK_REST_COMPONENT).contextPath(AppConfig.CONTEXT_PATH)
                .host(AppConfig.HOST).port(AppConfig.PORT);

        from(AppConfig.API_INPUT_ENDPOINT)
                .unmarshal().json(JsonLibrary.Jackson, Customer.class)
                .setProperty(AppConfig.CUSTOMER_PROPERTY, body()) // save the Customer object in a property
                .process(new CustomerToDocumentProcessor())
                .to(AppConfig.MONGODB_ENDPOINT)
                .process(sqlQueryPreparer)
                .to(AppConfig.JDBC_ENDPOINT)
                .process(restPayloadPreparer)
                .marshal().json(JsonLibrary.Jackson)
                .to(AppConfig.REST_ENDPOINT)
                .log("Sent REST response");
    }
}