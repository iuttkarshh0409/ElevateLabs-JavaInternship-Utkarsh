# 📚 RESTful Bookstore API

A robust and scalable backend API built with **Java** and **Spring Boot** to manage a bookstore's inventory. This project supports full CRUD operations for books and authors, with advanced features like pagination, sorting, and dynamic filtering. Developed as part of the **Elevate Labs Java Developer Internship** to master REST API design, database integration, and backend development best practices.

---

## 💻 Features

- ✅ **Full CRUD Operations**: Create, read, update, and delete `Book` and `Author` resources.
- ✅ **Advanced Querying**:
  - **Pagination**: Fetch data in pages (e.g., `?page=0&size=5`).
  - **Sorting**: Sort results by any field (e.g., `?sort=title,asc`).
  - **Dynamic Filtering**: Filter books by `title` or `genre` with partial or exact matches.
- ✅ **Interactive API Docs**: Auto-generated **Swagger UI** for live API testing and documentation.
- ✅ **In-Memory Database**: Uses **H2 Database** for fast, zero-setup development with automatic reset on launch.
- ✅ **Static Frontend**: Includes a simple `books.html` page to demonstrate API consumption.
- ✅ **Robust Error Handling**: Provides clear, specific error messages for invalid inputs and server issues.

---

## 🛠️ Tools & Technologies

- **Language**: Java 17
- **Framework**: Spring Boot 3.3.1
- **Data Persistence**: Spring Data JPA, Hibernate
- **Database**: H2 In-Memory Database
- **API Documentation**: SpringDoc OpenAPI (Swagger 3)
- **Build Tool**: Apache Maven
- **IDE**: Visual Studio Code

---

## 📂 Project Structure

```
bookstore-api/
├── src/
│   ├── main/
│   │   ├── java/com/utkarsh/bookstore/
│   │   │   ├── controller/   # REST API request handlers
│   │   │   ├── exception/    # Custom exception classes
│   │   │   ├── model/        # JPA @Entity classes (Book, Author)
│   │   │   ├── repository/   # Spring Data JPA repositories
│   │   │   └── service/      # Business logic implementation
│   │   └── resources/
│   │       ├── static/       # HTML, CSS, JS for frontend (books.html)
│   │       └── application.properties # Configuration (H2, server settings)
│   └── test/                 # Unit and integration tests
├── pom.xml                   # Maven dependencies and build configuration
└── README.md                 # Project documentation
```

### 📌 Key Components
- **BookController**: Handles HTTP requests for book-related endpoints (`/api/books`).
- **BookService**: Implements business logic for book operations.
- **BookRepository**: Interface for database interactions using Spring Data JPA and `JpaSpecificationExecutor`.
- **Book & Author**: JPA entities representing database tables.
- **Exception Classes**: Custom exceptions for robust error handling.

---

## 🔍 How It Works

- **Request Handling**: `BookController` processes HTTP requests (e.g., `GET`, `POST`) at `/api/books`.
- **Business Logic**: `BookService` handles operations like creating, updating, or filtering books.
- **Database Interaction**: `BookRepository` uses Spring Data JPA to interact with the H2 database, supporting CRUD and dynamic queries.
- **Advanced Querying**: Builds `Specification` objects for filtering (`title`, `genre`) and `Pageable` objects for pagination and sorting (`page`, `size`, `sort`).
- **Response Generation**: Returns JSON responses wrapped in `ResponseEntity` with appropriate HTTP status codes (e.g., 200 OK, 404 Not Found).
- **API Documentation**: Swagger UI at `/swagger-ui.html` provides interactive testing.
- **Frontend**: A static `books.html` page consumes the API to display book data.

---

## ✅ Key Features & Improvements

| Feature/Improvement            | Description                                              |
|-------------------------------|----------------------------------------------------------|
| Pagination & Sorting          | Handles large datasets with client-defined pagination and sorting |
| Dynamic Filtering            | Uses JPA `Specification` for flexible query building     |
| Interactive API Docs         | Swagger UI for live testing and clear documentation      |
| In-Memory Database           | H2 database for quick setup and development              |
| Layered Architecture         | Separates concerns (Controller, Service, Repository)     |
| Robust Error Handling        | Custom exceptions with clear, client-friendly messages   |
| Static Frontend              | `books.html` demonstrates real-world API consumption     |

---

## 🚀 Sample API Calls

**Base URL**: `http://localhost:8080`

### 1. Get Paginated Fantasy Books, Sorted by Newest
```
GET /api/books?genre=Fantasy&page=0&size=5&sort=publishedDate,desc
```

**Response** (JSON, partial):
```json
{
  "content": [
    {
      "id": 6,
      "title": "The Winds of Winter",
      "genre": "Fantasy",
      "publishedDate": "2023-12-01",
      "author": { "id": 1, "name": "George R.R. Martin" }
    }
    // ... 4 more books ...
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 5,
    "sort": { "sorted": true, "property": "publishedDate", "direction": "DESC" }
  },
  "totalPages": 4,
  "totalElements": 18
}
```

### 2. Get a Single Book by ID
```
GET /api/books/1
```

**Response** (JSON):
```json
{
  "id": 1,
  "title": "A Game of Thrones",
  "genre": "Fantasy",
  "publishedDate": "1996-08-01",
  "author": { "id": 1, "name": "George R.R. Martin" }
}
```

### 3. Access Swagger UI
- Open `http://localhost:8080/swagger-ui.html` in a browser to test endpoints interactively.

---

## 🔐 API Robustness & Edge Case Handling

| Case                              | Behavior                                              |
|-----------------------------------|-------------------------------------------------------|
| Resource Not Found                | Returns 404 Not Found with descriptive message        |
| Invalid Input                     | Returns 400 Bad Request for malformed request bodies  |
| Pagination Out of Bounds          | Returns empty content array                           |
| Server-Side Errors                | Returns 500 Internal Server Error with generic message|
| Lazy Loading Issues               | Resolved with `@Transactional` and proper JSON handling|

---

## 📌 How to Run

1. **Prerequisites**:
   - Java 17+
   - Maven 3.8+
   - MySQL (optional, for persistent DB; H2 is default)
2. **Clone the Repository**:
   ```bash
   git clone https://github.com/iuttkarshh0409/bookstore-api.git
   cd bookstore-api
   ```
3. **Build the Project**:
   ```bash
   mvn clean install
   ```
4. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```
5. **Access the API**:
   - API: `http://localhost:8080/api/books`
   - Swagger UI: `http://localhost:8080/swagger-ui.html`
   - Frontend: `http://localhost:8080/books.html`

### 📸 Notes
- The H2 database resets on each application restart.
- Update `application.properties` for a persistent database like MySQL if needed.

---

## 📎 Concepts Practiced

- **REST API Design**: Building RESTful endpoints with Spring Boot.
- **Spring Data JPA**: Using repositories and `JpaSpecificationExecutor` for dynamic queries.
- **Database Management**: H2 in-memory database for development.
- **API Documentation**: Auto-generated Swagger UI with SpringDoc OpenAPI.
- **Layered Architecture**: Separation of concerns (Controller, Service, Repository).
- **Error Handling**: Custom exceptions and meaningful HTTP responses.
- **Frontend Integration**: Static HTML for API consumption.

---

## 🙌 Author

**Utkarsh Dubey**  
*Java Developer Intern @ Elevate Labs*  
📍 Devi Ahilya Vishwavidyalaya, Indore  
💼 GitHub: [iuttkarshh0409](https://github.com/iuttkarshh0409)  
📧 Email: dubeyutkarsh101@gmail.com

---

## 📝 License

This project is open-source and free to use for educational and personal projects.