# 🧩 Spring Boot Kafka Microservices System

## 📌 Overview

This project is a **scalable microservices-based backend system** built using **Spring Boot, Apache Kafka, and Eureka Service Discovery**.

It simulates a real-world **e-commerce platform** with multiple independent services communicating via **REST and event-driven architecture (Kafka)**.

---

## 🏗️ Architecture Overview

```text
Client Request
     ↓
UserAuthService  ───────────────┐
                                │
ProductCatalogService           │
                                ├──> OrderService ──> Kafka ──> EmailService
CartService                    │
                                │
PaymentService  <───────────────┘

All services are registered with Eureka (ServiceDiscovery)
```

---

## ⚙️ Tech Stack

* **Java 17**
* **Spring Boot**
* **Spring Cloud (Eureka Discovery)**
* **Apache Kafka**
* **Spring Data JPA**
* **REST APIs**
* **Maven**
* **Git & GitHub**

---

## 📦 Microservices

### 🔹 1. UserAuthService

* Handles user registration & authentication
* Produces Kafka event: `signup`
* Sends user data for email notifications

---

### 🔹 2. ProductCatalogService

* Manages product data
* Provides product listing APIs

---

### 🔹 3. CartService

* Handles cart operations
* Add/remove/update items

---

### 🔹 4. OrderService

* Creates orders
* Communicates with User & Cart services
* Produces Kafka event: `createOrder`

---

### 🔹 5. PaymentService

* Handles payment processing
* Can be extended with real payment gateways

---

### 🔹 6. EmailService

* Kafka Consumer
* Listens to:

  * `signup` → sends welcome email
  * `createOrder` → sends order confirmation email

---

### 🔹 7. ServiceDiscovery (Eureka Server)

* Registers all services
* Enables service-to-service communication
* URL: `http://localhost:8761`

---

## 🔄 Kafka Event Flow

| Event       | Producer        | Consumer     | Action                   |
| ----------- | --------------- | ------------ | ------------------------ |
| signup      | UserAuthService | EmailService | Welcome email            |
| createOrder | OrderService    | EmailService | Order confirmation email |

---

## 🚀 How to Run the Project

### 1️⃣ Start Zookeeper

```bash
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

### 2️⃣ Start Kafka

```bash
.\bin\windows\kafka-server-start.bat .\config\server.properties
```

---

### 3️⃣ Start Services (Important Order)

1. ServiceDiscovery (Eureka Server)
2. UserAuthService
3. ProductCatalogService
4. CartService
5. OrderService
6. PaymentService
7. EmailService

---

### 4️⃣ Verify Services

Open:

```text
http://localhost:8761
```

You should see all services:

* USERAUTHSERVICE
* PRODUCTCATALOGSERVICE
* CARTSERVICE
* ORDERSERVICE
* PAYMENTSERVICE
* EMAILSERVICE

---

## 📬 API Endpoints (Sample)

### 👤 User

```
POST /users/signup
```

### 🛒 Cart

```
POST /cart/add
GET /cart/{userId}
```

### 📦 Order

```
POST /orders
GET /orders/{id}
```

### 💳 Payment

```
POST /payments
```

---

## 📧 Email Flow

* User signup → Kafka → EmailService → Welcome email
* Order created → Kafka → EmailService → Order confirmation

---

## 🧠 Key Concepts Implemented

* Microservices Architecture
* Service Discovery (Eureka)
* Inter-service communication
* Event-driven architecture (Kafka)
* Asynchronous messaging
* DTO pattern
* Layered architecture

---

## ⚠️ Configuration Notes

### Kafka

```
spring.kafka.bootstrap-servers=localhost:9092
```

### Email (Gmail SMTP)

```
smtp.gmail.com
port: 587
```

⚠️ Use **App Password**, not your Gmail password

---

## 📈 Future Enhancements

* API Gateway (Spring Cloud Gateway)
* Docker & Docker Compose
* Circuit Breaker (Resilience4j)
* Centralized Logging (ELK / Zipkin)
* Security (JWT Authentication)
* Load Balancing

---

## 👨‍💻 Author

**Sahithya KS**
Backend Developer | Java | Microservices

---

## ⭐ If you like this project

Give it a ⭐ on GitHub!
