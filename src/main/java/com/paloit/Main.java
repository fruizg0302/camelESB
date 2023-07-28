package com.paloit;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();

        MongoClientProvider mongoClientProvider = new MongoClientProvider();
        context.getRegistry().bind(AppConfig.MONGO_BEAN, mongoClientProvider.provide());

        DataSourceProvider dataSourceProvider = new DataSourceProvider();
        context.getRegistry().bind(AppConfig.DATASOURCE, dataSourceProvider.provide());

        context.addRoutes(new RestToRestRoute());
        context.start();

        // Keep the main thread running indefinitely
        while (true) {
            Thread.sleep(Long.MAX_VALUE);
        }
    }
}
