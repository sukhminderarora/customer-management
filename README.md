# Customer Management API

## Overview
This project is a Customer Management API developed using Java Spring Boot. It allows users to create and manage customer information, including first name, last name, and date of birth. The application follows RESTful principles and utilizes an H2 in-memory database for data storage.

## Features
- Create and retrieve customer information.
- Input validation to ensure data integrity.
- Error handling with clear messages.
- A user-friendly interface built with Thymeleaf and Bootstrap.
- View a list of all customers.

## Technologies Used
- **Java 17**: The programming language used for backend development.
- **Spring Boot**: Framework used to build the REST API.
- **H2 Database**: In-memory database for data storage during development.
- **Thymeleaf**: Server-side Java template engine for rendering web pages.
- **Bootstrap**: Frontend framework for responsive design.

## Endpoints
### User Interface Endpoints
- `GET /customers`: Show the customer creation form.
- `GET /customers/list`: Show the list of all customers.

### REST API Endpoints
- `POST /api/customers`: Create a new customer.
- `GET /api/customers`: Retrieve a list of all customers.

## Getting Started
### Prerequisites
- JDK 17 or later
- Gradle

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/customer-management-api.git
2. Import the project using build.gradle
3. Run the Spring Boot Application - Open a web browser and go to the following URL to access the customer management interface:
   ```bash
   http://localhost:8080/customers