package com.paloit;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoClientProvider {
    public MongoClient provide() {
        return MongoClients.create(AppConfig.MONGO_CONNECTION_STRING);
    }
}
