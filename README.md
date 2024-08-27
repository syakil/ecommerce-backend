# E-Commerce Application ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.3-brightgreen)
This is a modern e-commerce web application built using **Spring Boot 3.3.3** and **Java 17**. The application leverages several dependencies and technologies to provide a robust backend for managing products, customers, and orders.

## Features

- **Product Management**: Add, update, and delete products.
- **Order Management**: Place and manage customer orders.
- **Customer Management**: Handle user accounts and profiles.
- **Database Integration**: Built with PostgreSQL for efficient data handling.
- **Web Integration**: RESTful APIs for frontend interaction.

## Prerequisites

- **Java 17**
- **Maven 3.x**
- **PostgreSQL 13+**
- **Spring Boot 3.3.3**

## Dependencies

The application includes the following key dependencies:

- **Lombok**: Simplifies Java coding by providing annotations to reduce boilerplate code.
- **Spring JPA**: Easy ORM integration with PostgreSQL for database operations.
- **PostgreSQL**: Database system used to store product, customer, and order data.
- **Spring Dev Tools**: Provides development-time features for faster coding and testing.
- **Spring Web**: REST API support for handling web requests.
- **Spring Configuration Processor**: Generates metadata for IDE completion and configuration.

## Getting Started

### 1. Clone the repository:

```bash
git clone https://github.com/syakil/ecommerce-backend.git
cd ecommerce-backend

```

### 2. Configure PostgreSQL:

Set up a PostgreSQL database and provide connection details in the 
`application.properties` or `application.yml` file.


```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

```

### 3. Build and run the application:

Make sure all dependencies are resolved by running Maven commands:
    
```bash
mvn clean install
mvn spring-boot:run
```