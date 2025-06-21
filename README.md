#  Concert Booking Backend (Spring Boot)

A secure and scalable backend service for a Concert Booking Application, built with Java and Spring Boot. It includes user authentication, concert management, and ticket booking with constraints.

---

##  Key Features

- **JWT-based Authentication** (Login/Signup)
- **Concert CRUD Operations** (Admin only)
- **Ticket Booking System**  
  - Max 3 tickets per user per concert
- **Role-Based Access Control** (User/Admin)
- **RESTful API Design** with proper status codes
- **API Tested via Postman**

---

##  Tech Stack

- Java 17 • Spring Boot • Spring Security (JWT)  
- Spring Data JPA • MySQL   
- Postman for API testing

---

##  Project Highlights

- Modular structure (`controller`, `service`, `repository`, `config`)
- Secure endpoints with JWT token validation
- Booking constraints and validations applied
- Proper HTTP response handling (`200`, `401`, `403`, `400`, etc.)

---

##  API Testing

All endpoints tested using Postman.  
Sample requests cover:
- Auth (register/login)
- Concerts (CRUD)
- Ticket booking (with limits)

---

## ⚙️ Setup

```bash
git clone https://github.com/your-username/concert-booking-backend.git
cd concert-booking-backend
