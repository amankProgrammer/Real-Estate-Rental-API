# 🏠 Real Estate Rental API 

A high-performance RESTful backend service for a property rental platform. This system manages property listings, handles user inquiries, and supports advanced search filtering. Built with **Java** and **Spring Boot**, following industry-standard architecture.

## 🚀 Tech Stack
* **Language:** Java 17
* **Framework:** Spring Boot 3.x
* **Database:** MySQL 8.0
* **ORM:** Hibernate / Spring Data JPA
* **Validation:** Jakarta Validation API
* **Documentation:** Swagger UI (OpenAPI 3.0)
* **Testing:** JUnit 5 & Mockito

## ✨ Key Features
* **CRUD Operations:** Create, Read, Update, and Delete property listings.
* **Advanced Filtering:** Custom search logic to filter properties by *Location* and *Price Range* dynamically.
* **Data Integrity:** Robust input validation (e.g., negative prices, invalid phone numbers) with meaningful error messages.
* **Global Error Handling:** Centralized `@RestControllerAdvice` to transform server exceptions into clean JSON responses.
* **Scalable Architecture:** Layered design (Controller -> Service -> Repository) for maintainability.

## 🏗️ Architecture
The application follows the standard Spring Boot layered architecture:



1.  **Controller Layer:** Handles HTTP requests and Input Validation.
2.  **Service Layer:** Contains business logic and transaction management.
3.  **Repository Layer:** Interacts with MySQL using Hibernate/JPA.

## 🛠️ Installation & Setup

### Prerequisites
* Java JDK 17+
* Maven
* MySQL Server

### 1. Configure Database
Create a schema in your MySQL Workbench:
```sql
CREATE DATABASE nobroker_clone;
```

# Update src/main/resources/application.properties with your credentials:

Properties

```
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```


2. Run the Application
Bash
```
# Clone the repository
git clone [https://github.com/YOUR_USERNAME/rental-api.git](https://github.com/YOUR_USERNAME/rental-api.git)

# Build and Run
mvn spring-boot:run
🔌 API Documentation
Once the application is running, access the full interactive documentation here: 👉 http://localhost:8080/swagger-ui/index.html

Sample Endpoint: Add Property
POST /api/properties

JSON

{
  "title": "Luxury 2BHK in Indiranagar",
  "type": "RENT",
  "price": 35000.0,
  "location": "Bengaluru",
  "ownerContact": "9876543210"
}
Sample Endpoint: Filter Search
GET /api/properties/filter?location=Indira&min=20000&max=40000

🧪 Testing
Run the Unit Tests to verify business logic:

Bash

mvn test
```

# Future Improvements
- Implement JWT Authentication for secure user login.

- Add Redis Caching for frequently searched locations.

- Dockerize the application for easy deployment.


***
