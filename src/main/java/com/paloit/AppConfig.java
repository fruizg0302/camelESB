package com.paloit;

public class AppConfig {

    public static final String SPARK_REST_COMPONENT = "spark-rest";
    public static final String CONTEXT_PATH = "/api";
    public static final String HOST = "localhost";
    public static final int PORT = 8080;
    public static final String API_INPUT_ENDPOINT = "spark-rest:post:/api/input";
    public static final String MONGODB_ENDPOINT = "mongodb:myDb?database=test&collection=test&operation=insert&connectionBean=mongoBean";
    public static final String JDBC_ENDPOINT = "jdbc:myDataSource";
    public static final String REST_ENDPOINT = "http://localhost:3000/customers?bridgeEndpoint=true";
    public static final String CUSTOMER_PROPERTY = "customer";

    // DB Config
    public static final String DB_DRIVER = "org.postgresql.Driver";
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/camelTest";
    public static final String DB_USERNAME = "postgres";
    public static final String DB_PASSWORD = "postgres";

    // Mongo Config
    public static final String MONGO_CONNECTION_STRING = "mongodb://root:a05pwd8u#d6J@localhost:27017";
    public static final String MONGO_BEAN = "mongoBean";

    // Data Source
    public static final String DATASOURCE = "myDataSource";

}
