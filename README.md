📘 User & Expense Management System

A Spring Boot REST API for managing users and their expenses with manager-controlled approval flow, input validation, Liquibase database migrations, and clean layered architecture.

🚀 Features
👤 User Management

Create users with validation

Fetch all users

Fetch user by ID

Delete users

Prevent duplicate emails

💰 Expense Management

Manager creates expenses for users

Expense status defaults to NOT_APPROVED

Manager can approve / reject expenses

Fetch all expenses

Fetch expense by ID

Delete expenses

✅ Validation

Email format validation

Mobile number must be exactly 10 digits

Amount must be greater than zero

Required fields enforced

🗃 Database & Migrations

PostgreSQL database

Liquibase for schema migrations

Versioned changelogs

Automatic table creation

🛡 Exception Handling

Centralized global exception handler

Meaningful HTTP status codes

Validation error responses

🏗 Tech Stack
Layer	Technology
Language	Java 21
Framework	Spring Boot 4
Database	PostgreSQL
ORM	Spring Data JPA (Hibernate)
Migrations	Liquibase
Validation	Jakarta Validation
Build Tool	Maven
API Testing	Postman
📂 Project Structure
src/main/java/com/example/user_management
│
├── controller
│   ├── UserController.java
│   └── ExpenseController.java
│
├── dto
│   ├── UserRequest.java
│   └── ManagerExpenseRequest.java
│
├── entity
│   ├── User.java
│   └── Expense.java
│
├── enums
│   ├── ExpenseCategory.java
│   └── ExpenseStatus.java
│
├── repository
│   ├── UserRepository.java
│   └── ExpenseRepository.java
│
├── service
│   ├── UserService.java
│   ├── ExpenseService.java
│   └── impl
│       ├── UserServiceImpl.java
│       └── ExpenseServiceImpl.java
│
├── exception
│   ├── GlobalExceptionHandler.java
│   ├── ResourceNotFoundException.java
│   └── DuplicateEmailException.java
│
└── UserManagementApplication.java

🗄 Database Migrations (Liquibase)
src/main/resources/db/changelog
│
├── db.changelog-master.xml
├── 001-create-users.xml
└── 002-create-expenses.xml


Liquibase automatically:

Creates tables

Maintains databasechangelog

Prevents duplicate execution

⚙️ Configuration
application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/userdb
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true

spring.liquibase.change-log=classpath:db/changelog/db.changelog-master.xml

server.port=8080

▶️ Running the Application
1️⃣ Start PostgreSQL

Ensure a database exists:

CREATE DATABASE userdb;

2️⃣ Run the application
./mvnw clean spring-boot:run


Application runs on:

http://localhost:8080

📌 API Endpoints
👤 Users
Method	Endpoint	Description
POST	/api/users	Create user
GET	/api/users	Get all users
GET	/api/users/{id}	Get user by ID
DELETE	/api/users/{id}	Delete user
💰 Expenses
Method	Endpoint	Description
POST	/api/expenses	Create expense (manager)
GET	/api/expenses	Get all expenses
GET	/api/expenses/{id}	Get expense by ID
PATCH	/api/expenses/{id}/status	Approve / Reject
DELETE	/api/expenses/{id}	Delete expense
🧪 Sample Requests
Create User
POST /api/users
{
  "name": "User Alpha",
  "email": "user.alpha@test.com",
  "mobile": "9876543210"
}

Create Expense
POST /api/expenses
{
  "userId": 1,
  "amount": 500,
  "category": "FOOD",
  "expenseDate": "2026-01-15"
}

Approve Expense
PATCH /api/expenses/1/status?status=APPROVED

🧾 Enums
ExpenseCategory
FOOD
TRAVEL
HOTEL
MEDICAL

ExpenseStatus
NOT_APPROVED
APPROVED

❌ Error Handling
Scenario	Status
Validation failure	400
Resource not found	404
Duplicate email	409
Server error	500
🔮 Future Enhancements

JWT Authentication & Role-based access

Pagination & sorting

Expense reports

Swagger / OpenAPI documentation

Unit & integration tests

👨‍💻 Author

Akshat Pal
Backend Developer | Java | Spring Boot
