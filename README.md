# 🚀 Spring Boot Quiz REST API

A simple **Quiz Application Backend** built using **Spring Boot** to understand and practice **RESTful APIs**, request–response flow, and database integration.  
This project does not include a frontend and is tested using **Postman**.

The project is created for learning purposes to gain hands-on experience with backend development using Spring Boot.

---

## 📌 Overview

This application provides REST APIs to manage quiz questions and dynamically generate quizzes based on category and number of questions. It also supports submitting quiz responses and evaluating results.

The primary focus of this project is to understand:
- REST architecture
- Layered backend design
- JPA and Hibernate relationships
- API testing using Postman

---

## ✨ Features

- Create and store quiz questions  
- Generate quizzes dynamically by category  
- Fetch quizzes using REST APIs  
- Submit quiz responses and evaluate answers  
- Persist data using Spring Data JPA  

---

## 🛠️ Tech Stack

- **Language:** Java  
- **Framework:** Spring Boot  
- **ORM:** Spring Data JPA, Hibernate  
- **Database:** MySQL  
- **API Testing:** Postman  
- **Build Tool:** Maven  

---

## 📂 Project Structure

text
src/main/java
 └── in.sp.main
     ├── controller   // REST controllers
     ├── service      // Business logic
     ├── dao          // JPA repositories
     ├── beans        // Entity classes
     └── QuizAppApplication.java
🔗 API Endpoints
📘 Question APIs
POST /api/questions – Add a new question

GET /api/questions – Get all questions

GET /api/questions?category={category} – Get questions by category

📝 Quiz APIs
POST /api/quizzes?category={category}&numQ={number}&title={title} – Create a quiz

GET /api/quizzes/{id} – Fetch quiz by ID

POST /api/quizzes/{id}/submit – Submit quiz responses

🗄️ Database Configuration
This project uses MySQL.
Configure database properties in application.properties.

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/quiz_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
🧪 Testing
All APIs are tested using Postman

Requests and responses use JSON format

No frontend interface is included

(Optional: A Postman collection can be added to the repository.)

🎯 Learning Objectives
This project helped me understand:

REST API development using Spring Boot

Controller–Service–Repository architecture

Entity relationships with JPA

HTTP methods and status codes

API testing workflows with Postman

🚧 Future Enhancements
User authentication and authorization

Frontend integration (React / Angular)

Improved validation and exception handling

Pagination and filtering

👤 Author
Sahil Patil
Computer Engineering Student
Java & Spring Boot Backend Learner

📺 Reference
Tutorial followed for learning and implementation:
https://youtu.be/vlz9ina4Usk
