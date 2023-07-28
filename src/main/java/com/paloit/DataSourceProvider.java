package com.paloit;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataSourceProvider {
    public BasicDataSource provide() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(AppConfig.DB_DRIVER);
        dataSource.setUrl(AppConfig.DB_URL);
        dataSource.setUsername(AppConfig.DB_USERNAME);
        dataSource.setPassword(AppConfig.DB_PASSWORD);
        return dataSource;
    }
}
