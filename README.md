# E-commerce Project Documentation

## Overview

The E-commerce project is a Spring Boot application that serves as a backend system for managing products, customers, carts, orders, and order items in an e-commerce platform.

## Features

- **Product Management**: Allows users to create, retrieve, update, and delete products. Products contain information such as name, price, and stock quantity.
- **Customer Management**: Enables users to manage customers, including creating, retrieving, updating, and deleting customer information.
- **Cart Management**: Provides functionality for managing shopping carts, allowing users to add products to carts, update cart contents, and view cart details.
- **Order Management**: Supports creating and managing orders, including adding items to orders, updating order information, and retrieving order details.
- **Historical Price Tracking**: Tracks historical price changes for products to enable retrospective viewing of prices at the time of purchase.

## Technologies Used

- **Spring Boot**: Framework for building Spring-based applications, providing features such as auto-configuration and embedded servers.
- **Spring Data JPA**: Part of the Spring Data project, simplifies data access with JPA (Java Persistence API) repositories.
- **Hibernate**: ORM (Object-Relational Mapping) framework for mapping Java objects to database tables.
- **PostgreSQL**: Relational database management system used for persisting application data.
- **ModelMapper**: Library for mapping objects between different layers of an application.
- **Validation**: Utilizes Spring's validation framework for input validation and error handling.

## Endpoints

The application exposes the following REST endpoints:

- **Products**:
  - `GET /api/products`: Retrieve all products.
  - `GET /api/products/{id}`: Retrieve a specific product by ID.
  - `POST /api/products`: Create a new product.
  - `PUT /api/products/{id}`: Update an existing product.
  - `DELETE /api/products/{id}`: Delete a product.

- **Customers**:
  - `GET /api/customers`: Retrieve all customers.
  - `GET /api/customers/{id}`: Retrieve a specific customer by ID.
  - `POST /api/customers`: Create a new customer.
  - `PUT /api/customers/{id}`: Update an existing customer.
  - `DELETE /api/customers/{id}`: Delete a customer.

- **Carts**:
  - `GET /api/carts/{customerId}`: Retrieve the cart for a specific customer.
  - `POST /api/carts/{customerId}/items`: Add an item to the customer's cart.
  - `PUT /api/carts/{customerId}/items/{productId}`: Update the quantity of an item in the customer's cart.
  - `DELETE /api/carts/{customerId}/items/{productId}`: Remove an item from the customer's cart.

- **Orders**:
  - `GET /api/orders/{id}`: Retrieve a specific order by ID.
  - `POST /api/orders`: Create a new order.
  - `PUT /api/orders/{id}`: Update an existing order.
  - `DELETE /api/orders/{id}`: Delete an order.

## Usage

1. **Running the Application**:
   - Clone the project from the repository.
   - Set up the database connection properties in the `application.properties` file.
   - Build and run the application using Maven or your preferred IDE.

2. **Testing Endpoints**:
   - Use tools like Postman or cURL to send HTTP requests to the exposed endpoints.
   - Refer to the endpoint documentation above for details on request and response formats.

3. **Data Population**:
   - Populate the database with sample data using the provided JSON examples or create your own data as needed.
   - Use the provided JSON examples to test CRUD operations and application functionality.

## Future Enhancements

- **Authentication and Authorization**: Implement user authentication and role-based access control for securing endpoints.
- **Frontend Integration**: Develop a frontend application to interact with the backend API, providing a user-friendly interface for managing e-commerce operations.
- **Enhanced Error Handling**: Improve error handling and validation messages to provide better feedback to API consumers.
- **Performance Optimization**: Optimize database queries and application logic for improved performance and scalability.

## Conclusion

The E-commerce project provides a robust backend solution for managing various aspects of an e-commerce platform, including products, customers, carts, orders, and historical price tracking. With its RESTful API and flexible architecture, the application can be easily extended and integrated with frontend or third-party systems.
