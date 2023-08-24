```markdown
# CamelESB

CamelESB is a Java project developed by `com.paloit` to facilitate various integration patterns and components using Apache Camel.

## Prerequisites

- Java JDK 11
- Maven

## Features

- Integration with MongoDB using the `camel-mongodb` component.
- Integration with PostgreSQL using the JDBC and the `camel-jdbc` component.
- Route for transforming REST to REST.
- Assembly plugin to build a fat jar containing all the required dependencies.

## Dependencies

- Apache Camel Core (`camel-core`)
- Apache Camel Servlet (`camel-servlet`)
- Apache Camel MongoDB (`camel-mongodb`)
- Apache Camel JDBC (`camel-jdbc`)
- Apache Camel HTTP (`camel-http`)
- Apache Camel Spark REST (`camel-spark-rest`)
- PostgreSQL JDBC (`postgresql`)
- Apache Commons DBCP2 (`commons-dbcp2`)
- Logback Classic (`logback-classic`)

## Getting Started

### Building the Project

1. Clone this repository.
2. Navigate to the project directory.
3. Run the following command to build the project:

```bash
mvn clean package
```

This command will build a fat jar named `CamelESB-1.0-SNAPSHOT-jar-with-dependencies.jar` inside the `target` directory.

### Running the Application

You can run the application using the following command:

```bash
java -jar target/CamelESB-1.0-SNAPSHOT-jar-with-dependencies.jar
```

Upon running, the application initializes a `CamelContext` and sets up connections to MongoDB and a JDBC data source. The `RestToRestRoute` is added to the context, which starts and awaits incoming connections.

## Configuration

Configuration and provisioning of MongoDB client and JDBC DataSource are handled by `MongoClientProvider` and `DataSourceProvider` respectively. Ensure you have the necessary configuration set up for these components before running the application.

## Contributing

Please follow the standard pull request process if you have any updates you'd like to contribute.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

## Contact

For any questions or concerns, please open an issue on this repository, and we'll get back to you as soon as possible.
```