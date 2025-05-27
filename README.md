# MyBlogAPI 🚀

MyBlogAPI is a robust Spring Boot REST API that powers the backend for the [MyBlog](https://github.com/farid-kheli/Myblog) platform. It provides endpoints for retrieving blogs, searching, filtering by category, and managing comments.

---

## ✨ Features

- 📚 Fetch all blogs with author and engagement details
- 🔎 Search blogs by title
- 💬 Retrieve comments for a specific blog
- 🏷️ Filter blogs by category
- 📝 Get a single blog by ID

---

## 🛠️ Tech Stack

- ☕ Java 24
- 🌱 Spring Boot 3.5.0
- 🗄️ Spring Data JPA
- 🐬 MySQL

---

## 🚦 Getting Started

### Prerequisites

- Java 17+ (Java 24 recommended)
- Maven
- MySQL database (with the schema from your MyBlog project)

### Configuration

Update your database credentials in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/WebApp
spring.datasource.username=root
spring.datasource.password=
```

### Build & Run

```sh
./mvnw clean package
java -jar target/MyBlog-0.0.1-SNAPSHOT.jar
```

API will be available at: `http://localhost:8081/api`

---

## 📖 API Endpoints

| Method | Endpoint                | Description                     |
|--------|-------------------------|---------------------------------|
| GET    | `/api/blogs`            | Get all blogs                   |
| POST   | `/api/blogs/search`     | Search blogs by title           |
| POST   | `/api/blogs/comments`   | Get comments for a blog         |
| POST   | `/api/blogs/`           | Get a blog by ID                |
| POST   | `/api/blogs/categroy`   | Get blogs by category           |

### Example: Get All Blogs

```sh
curl http://localhost:8081/api/blogs
```

### Example: Search Blogs

```sh
curl -X POST http://localhost:8081/api/blogs/search -d "search=keyword"
```

---

## 🔗 Related Projects

- [MyBlog](https://github.com/farid-kheli/Myblog) — The main blog website using this API

---
