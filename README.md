# 📅 Day 1 - DBMS Fundamentals & RDBMS Basics

## 🎯 Objective
Build a strong foundation in Database Management Systems and SQL fundamentals.

## 📚 Topics Covered

- Introduction to DBMS
- DBMS vs File System
- Types of Databases (SQL & NoSQL)
- RDBMS Concepts
- Tables, Rows & Columns
- Primary Key & Foreign Key
- Constraints
- Database Relationships
- DDL (CREATE, ALTER, DROP, TRUNCATE)
- DML (INSERT, UPDATE, DELETE, SELECT)

## 💻 Practical Work

- ✔ Created a MySQL Database
- ✔ Executed DDL Commands
- ✔ Performed DML Operations
- ✔ Created Tables with Constraints
- ✔ Inserted, Updated & Deleted Records

## 📂 Files

```
day-1/
├── DDL Commands.sql
├── DML Commands.sql
└── README.md
```

## 🧠 Key Takeaways

- Understand when to use SQL vs NoSQL
- Design relational tables using keys
- Differentiate DDL and DML
- Perform basic database operations
- Build a strong foundation for backend development

## 🚀 Progress

| Day | Topic | Status |
|------|---------------------------|--------|
| 1 | DBMS Fundamentals & RDBMS Basics | ✅ Completed |

---

# 📅 Day 2 - ER Diagram, Indexing & Normalization

## 🎯 Objective
Design a relational database using an ER Diagram and apply database normalization for an efficient schema.

## 📚 Topics Covered

- ER Diagram (ERD)
- Entities & Attributes
- Primary & Foreign Keys
- Relationships (1:1, 1:N, M:N)
- Cardinality
- Normalization (1NF, 2NF, 3NF, BCNF)
- SQL Indexing Basics

## 💻 Practical Work

- ✔ Designed the Health Clinic ER Diagram
- ✔ Created normalized database schema
- ✔ Defined Primary & Foreign Keys
- ✔ Established table relationships
- ✔ Implemented the Health Clinic Database in SQL

## 🏥 Database Entities

- Department
- Doctor
- Patient
- Appointment

## 📂 Files

```
day-2/
├── ER Diagram.png
├── HealthClinicApp.sql
├── PracticeHealthClinicApp.sql
└── README.md
```

## 🧠 Key Takeaways

- Design databases using ER Diagrams
- Create relationships using PK & FK
- Apply normalization to reduce redundancy
- Build a clean and scalable database schema

## 🚀 Progress

| Day | Topic | Status |
|------|---------------------------------|--------|
| 2 | ER Diagram, Indexing & Normalization | ✅ Completed |

---
# 📅 Day 3 - SQL Joins, Stored Procedures & Triggers

## 🎯 Objective
Learn how to retrieve data from multiple tables, automate database operations, and improve SQL query reusability.

## 📚 Topics Covered

- SQL Joins
- INNER JOIN
- LEFT JOIN
- RIGHT JOIN
- FULL OUTER JOIN
- Stored Procedures
- Triggers
- Database Automation

## 💻 Practical Work

- ✔ Performed SQL Join operations
- ✔ Created Stored Procedures
- ✔ Implemented INSERT & DELETE Triggers
- ✔ Logged database activities using Trigger Tables
- ✔ Queried data from the Health Clinic Database

## 🏥 Database Entities

- Doctor
- Patient
- Appointment
- Patient_Log
- Delete_Log

## 📂 Files

```text
Day-3/
├── ERdiagramDay3.png
├── HealthClinicAppDay3.sql
└── README.md
```

## 🧠 Key Takeaways

- Retrieve related data using SQL Joins
- Reuse queries with Stored Procedures
- Automate database actions using Triggers
- Maintain logs for database events
- Improve SQL query organization

## 🚀 Progress

| Day | Topic | Status |
|------|--------------------------------------|--------|
| 3 | SQL Joins, Stored Procedures & Triggers | ✅ Completed |

---
# 📅 Day 4 - JDBC & Health Clinic App

## 🎯 Objective
Connect a Java application with MySQL using JDBC and implement CRUD operations using a layered architecture.

## 📚 Topics Covered

- JDBC Fundamentals
- Java-MySQL Connection
- CRUD Operations
- DAO Pattern
- Layered Architecture
- Maven Project Structure
- MySQL Integration

## 💻 Practical Work

- ✔ Connected Java application to MySQL using JDBC
- ✔ Built the Health Clinic Console Application
- ✔ Implemented CRUD operations
- ✔ Created DAO, Service & Model layers
- ✔ Managed Patients, Doctors & Appointments

## 🏥 Project Modules

- Patient Management
- Doctor Management
- Appointment Management
- Database Connectivity

## 📂 Project Structure

```text
Day-4/
└── health-clinic-app/
    ├── connection/
    ├── dao/
    ├── model/
    ├── service/
    ├── main/
    └── App.java
```

## 🧠 Key Takeaways

- Connect Java with MySQL using JDBC
- Perform CRUD operations efficiently
- Organize code using DAO Pattern
- Build scalable Java applications with layered architecture

## 🚀 Progress

| Day | Topic | Status |
|------|-----------------------------------|--------|
| 4 | JDBC & Health Clinic App | ✅ Completed |

---
# 📅 Day 5 - Tomcat, Servlets & Spring Introduction

## 🎯 Objective
Learn the basics of Java web development, Servlets, Tomcat, and Spring IoC/Dependency Injection.

## 📚 Topics Covered

- Apache Tomcat
- Servlet Basics
- Servlet Lifecycle
- Spring Framework
- IoC (Inversion of Control)
- Dependency Injection
- XML Configuration
- Annotation-Based Configuration
- Java-Based Configuration

## 💻 Practical Work

- ✔ Created and executed a basic Servlet
- ✔ Practiced Spring IoC & Dependency Injection
- ✔ Created Spring projects using 3 configuration approaches
- ✔ XML-Based Configuration
- ✔ Annotation-Based Configuration
- ✔ Java-Based Configuration

## 📂 Projects

```text
Day-5/
├── FirstServlet/
├── XML Configuration/
├── AnnotationBased/
├── JavaBased/
└── README.md
```

## 🧠 Key Takeaways

- Understand how Tomcat runs Java web applications
- Understand the Servlet lifecycle
- Understand IoC and Dependency Injection
- Configure Spring using XML, Annotations, and Java

## 🚀 Progress

| Day | Topic | Status |
|------|--------------------------------|--------|
| 5 | Tomcat, Servlets & Spring Introduction | ✅ Completed |

---
# 📅 Day 6 - Spring MVC

## 🎯 Objective
Learn Spring MVC architecture and build simple web applications using Controllers, Views, and Request Mapping.

## 📚 Topics Covered

- Spring MVC Architecture
- DispatcherServlet
- Controllers
- Request Mapping
- Request & Response Handling
- Model and View
- Maven Project Structure

## 💻 Practical Work

- ✔ Created a Spring MVC project
- ✔ Built **My Greetings App**
- ✔ Built a simple **Login Application**
- ✔ Implemented Controllers and Request Mapping
- ✔ Connected Requests with Views

## 📂 Projects

```text
Day-6/
├── MVCLogin/
│   ├── src/main/
│   ├── pom.xml
│
├── MyGreetingsApp/
│   ├── src/main/
│   ├── pom.xml
```

## 🧠 Key Takeaways

- Understand the role of DispatcherServlet
- Handle requests using Controllers
- Map URLs using `@RequestMapping`
- Connect Controllers with Views
- Understand the basic Spring MVC request flow

## 🚀 Progress

| Day | Topic | Status |
|------|----------------------|--------|
| 6 | Spring MVC | ✅ Completed |

---

# 📅 Day 7 - Spring REST API & Request Handling

## 🎯 Objective

Learn to build RESTful APIs using Spring and understand basic request handling for backend applications.

## 📚 Topics Covered

- Spring REST API
- RESTful Endpoints
- Request & Response Handling
- H2 In-Memory Database Basics
- Distributed Architecture Overview

## 💻 Practical Work

- ✔ Created the Contacts App backend
- ✔ Implemented basic REST endpoints
- ✔ Handled API requests and responses
- ✔ Started backend development using Spring

## 📂 Project

```text
Day-7/
└── contacts-app/
    ├── src/
    │   ├── main/
    │   └── test/
    ├── pom.xml
    ├── mvnw
    └── mvnw.cmd
```

## 🧠 Key Takeaways

- Build RESTful endpoints using Spring
- Handle HTTP requests and responses
- Understand basic REST architecture
- Understand the purpose of H2 in-memory databases

## 🚀 Progress

| Day | Topic | Status |
|------|----------------------------------|--------|
| 7 | Spring REST API & Request Handling | ✅ Completed |

---
# 📅 Day 8 - API Testing Tools & SDLC

## 🎯 Objective

Learn API testing and understand the role of backend development in the Software Development Life Cycle (SDLC).

## 📚 Topics Covered

- REST Assured
- JSON Server
- API Testing
- Swagger / API Documentation
- SDLC Basics
- REST API Validation

## 💻 Practical Work

- ✔ Continued the Contacts App backend
- ✔ Created test cases for REST APIs
- ✔ Tested Contacts App endpoints using REST Assured
- ✔ Added Swagger for API documentation
- ✔ Practiced API request and response validation

## 📂 Project

```text
Day-8/
└── contacts-app/
    ├── src/
    │   ├── main/
    │   └── test/
    ├── pom.xml
    ├── mvnw
    └── mvnw.cmd
```

## 🧠 Key Takeaways

- Test REST APIs using REST Assured
- Understand API mocking and testing with JSON Server
- Document and explore APIs using Swagger
- Understand the role of backend development in SDLC

## 🚀 Progress

| Day | Topic | Status |
|------|---------------------------|--------|
| 8 | API Testing Tools & SDLC | ✅ Completed |

---
# 📅 Day 9 - Spring Boot Fundamentals

## 🎯 Objective

Learn Spring Boot fundamentals and build REST APIs with database integration and unit testing.

## 📚 Topics Covered

- Spring Boot Fundamentals
- Auto-Configuration
- Spring Boot Starters
- Embedded Server
- Spring Controller & REST API
- H2 Database
- Mockito Testing

## 💻 Practical Work

- ✔ Continued the Contacts App using Spring Boot
- ✔ Added H2 Database integration
- ✔ Created REST API endpoints
- ✔ Added unit tests using Mockito
- ✔ Tested the backend application

## 📂 Project

```text
Day-9/
└── contacts-app/
    ├── src/
    │   ├── main/
    │   └── test/
    ├── pom.xml
    ├── mvnw
    └── mvnw.cmd
```

## 🧠 Key Takeaways

- Understand Spring Boot auto-configuration
- Use Spring Boot starters and embedded server
- Build REST APIs using Spring Boot
- Integrate H2 Database
- Write unit tests using Mockito

## 🚀 Progress

| Day | Topic | Status |
|------|--------------------------|--------|
| 9 | Spring Boot Fundamentals | ✅ Completed |

---

# 📅 Day 10 - Dependency Injection & H2 Database

## 🎯 Objective

Understand Dependency Injection in Spring Boot and integrate H2 Database into a backend application.

## 📚 Topics Covered

- Dependency Injection in Spring Boot
- H2 Database Integration
- H2 Configuration
- Entity Mapping
- Repository Layer
- Service Layer
- REST Controller

## 💻 Practical Work

- ✔ Created the Employee Payroll Application
- ✔ Integrated H2 Database
- ✔ Implemented Dependency Injection
- ✔ Created Entity, Repository and Service layers
- ✔ Added DTO and Mapper layers
- ✔ Added Exception Handling
- ✔ Added test structure

## 📂 Project

```text
Day-10/
└── Employee-Pay-Role/
    └── src/
        ├── main/
        │   ├── java/com/employeepayroll/
        │   │   ├── Controller/
        │   │   ├── Dto/
        │   │   ├── Entity/
        │   │   ├── Exception/
        │   │   ├── Mapper/
        │   │   ├── Repository/
        │   │   └── Service/
        │   └── resources/
        │
        └── test/
            └── java/com/employeepayroll/
```

## 🧠 Key Takeaways

- Understand Dependency Injection in Spring Boot
- Configure and use H2 Database
- Separate application logic into layers
- Understand Entity, Repository and Service responsibilities
- Structure a Spring Boot application cleanly

## 🚀 Progress

| Day | Topic | Status |
|------|-------------------------------------|--------|
| 10 | Dependency Injection & H2 Database | ✅ Completed |

---

