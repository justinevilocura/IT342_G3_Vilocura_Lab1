# User Registration and Authentication System

## Project Description
This project implements a secure User Registration and Authentication system using Spring Boot for the backend and ReactJS for the web frontend. It features JWT-based authentication, password encryption, and a protected user dashboard.

## Technologies Used
- **Backend**: Java, Spring Boot, Spring Security (JWT), Spring Data JPA, Hibernate, MySQL, Maven/Gradle
- **Frontend**: ReactJS, React Router, Axios, Bootstrap
- **Database**: MySQL

## Steps to Run

### Backend
1.  Ensure MySQL is running and a database named `dbg3vilocura` exists (or let Hibernate update it).
2.  Navigate to the `backend/springboot` directory.
3.  Update `src/main/resources/application.properties` with your MySQL credentials if different from `root` (empty password).
4.  Run the application:
    ```bash
    ./gradlew bootRun
    ```

### Web App
1.  Navigate to the `web` directory.
2.  Install dependencies (if not already installed):
    ```bash
    npm install
    ```
3.  Start the development server:
    ```bash
    npm start
    ```
4.  Open [http://localhost:3000](http://localhost:3000) in your browser.

### Mobile App
*Mobile application implementation is scheduled for the next session.*

## List of API Endpoints

### Authentication
-   `POST /api/auth/register`: Register a new user.
    -   Body: `{ "username": "...", "email": "...", "password": "..." }`
-   `POST /api/auth/login`: Authenticate user and receive JWT.
    -   Body: `{ "username": "...", "password": "..." }`

### User
-   `GET /api/user/me`: Get current user details (Protected).
    -   Headers: `Authorization: Bearer <token>`