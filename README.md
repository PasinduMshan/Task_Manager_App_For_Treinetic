# 📝 Task Manager App

A Full Stack Task Manager Web Application built using **Spring Boot (Java)** for the backend and **Angular** (frontend in progress). This app allows users to manage tasks with Create, Read, Update, and Delete (CRUD) operations. Backend includes **JWT-based authentication** and is **Dockerized** for seamless deployment.

---

## 🌐 GitHub Repository

🔗 [https://github.com/PasinduMshan/Task_Manager_App_For_Treinetic.git](https://github.com/PasinduMshan/Task_Manager_App_For_Treinetic.git)

---

## ✅ Features

### 🖥️ Frontend (Angular) - _In Progress_
- Task List View
- Add/Edit Task Form (Reactive Forms)
- Routing & HttpClient for API calls
- Form Validation
- Error handling
- UI Enhancements (Planned: Angular Material/Bootstrap)
- Login Page for JWT Authentication (Planned)

### 🔧 Backend (Spring Boot + JWT + Docker)
- RESTful APIs for Task CRUD
- JWT-based User Authentication
- DTOs and Service-Layer architecture
- Validation & Global Exception Handling
- Spring Data JPA + MySQL
- CORS enabled for frontend access
- Dockerized Spring Boot application

---

## 🗄️ Task Entity

```java
public class Task {
    private Long id;
    private String title;
    private String description;
    private String status;
    private LocalDateTime createdAt;
}
```

## 🗄️ User Entity

```java
public class User {
    private Long id;
    private String username;
    private String password;
}
```

## 🧪 How to Run the Project

> Ensure you have Docker installed before proceeding.

### 🔥 Run Entire Stack with Docker Compose

```bash
docker-compose up --build
```

## 📦 API Endpoints

**Main URL**: `http://localhost:8080/TaskManagerApp`

| Method | Endpoint               | Description              | Auth Required |
|--------|------------------------|--------------------------|---------------|
| GET    | `/api/v1/tasks`        | Get all tasks            | ✅ Yes        |
| GET    | `/api/v1/tasks/{id}`   | Get task by ID           | ✅ Yes        |
| POST   | `/api/v1/tasks`        | Create new task          | ✅ Yes        |
| PUT    | `/api/v1/tasks/{id}`   | Update task              | ✅ Yes        |
| DELETE | `/api/v1/tasks/{id}`   | Delete task              | ✅ Yes        |
| POST   | `/api/v1/auth/signUp`  | Register new user        | ❌ No         |
| POST   | `/api/v1/auth/signIn`  | Login, returns JWT token | ❌ No         |
