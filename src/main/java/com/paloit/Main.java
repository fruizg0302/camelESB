package com.paloit;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.commons.dbcp2.*;

public class Main {
    public static void main(String[] args) throws Exception {

        CamelContext context = new DefaultCamelContext();

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/camelTest");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");

        String mongoConnectionString = "mongodb://root:a05pwd8u#d6J@localhost:27017";
        context.getRegistry().bind("mongoBean", mongoConnectionString);

        context.getRegistry().bind("myDataSource", dataSource);

        MongoClient mongoClient = MongoClients.create("mongodb://root:a05pwd8u#d6J@localhost:27017");
        context.getRegistry().bind("mongoBean", mongoClient);

        context.addRoutes(new RestToRestRoute());
        context.start();

        // Keep the main thread running indefinitely
        while (true) {
            Thread.sleep(Long.MAX_VALUE);
        }
    }
}

