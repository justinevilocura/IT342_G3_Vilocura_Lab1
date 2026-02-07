🌐 Unitra: SME Resource Sharing & Collaboration Network
IT342 Laboratory Session 1: Core Backend & Web Application

📖 Project Description
Unitra is a professional web-based platform designed for Small and Medium Enterprises (SMEs) to optimize resource usage. It replaces informal communication with a structured environment where businesses can create profiles, share equipment, and exchange services. This repository contains the MVP (Minimum Viable Product) focusing on secure registration and authentication.

🛠️ Technology Stack
📖 Project Overview

Unitra is a professional, web-based collaboration platform designed for Small and Medium Enterprises (SMEs) to efficiently share resources and services.
It replaces informal communication channels with a secure, structured system where businesses can:
Create verified SME profiles
Auhenticate securely
Prepare for resource and service exchange workflows
This repository contains the Minimum Viable Product (MVP), focusing on secure registration, authentication, and backend architecture required for future expansion.

🎯 MVP Scope (Session 1)

This phase focuses on building a secure and scalable foundation for the platform.

✅ Implemented Features
1. SME Profile Management
Secure SME registration and login
Password encryption using BCrypt
Persistent storage of business profile data using MySQL
Protected profile access via authentication

2. Resource & Service Exchange (Architecture Ready)
Architecture supports listing, requesting, and real-time status updates (Pending, Approved, Declined).

4. Backend design prepared for:
Resource listing
Service requests
Status tracking (Pending, Approved, Declined)

Logic hooks and structure in place for future sessions

🛠️ Technology Stack
Layer	Technologies
Backend: Java 17, Spring Boot, Spring Security, Hibernate, BCrypt
Databas: MySQL
Frontend: ReactJS, Axios, React Router, Bootstrap
Environment: Cloud-ready Web Application

⚙️ Installation & Setup

1️⃣ Database Configuration
Ensure MySQL is installed and running.
Create the project database:
CREATE DATABASE dbg3vilocura;
Update database credentials in:
backend/springboot/src/main/resources/application.properties

2️⃣ Backend Execution (Spring Boot)
Navigate to the backend root directory and run:

cd backend/springboot
./gradlew bootRun

The backend will start on the default Spring Boot port.

3️⃣ Frontend Execution (React)
Navigate to the web directory:
cd web
npm install
npm start
Access the application at:
http://localhost:3000

📡 API Endpoints Summary
Method	Endpoint	Description
POST	/api/auth/register	SME Registration
POST	/api/auth/login	Secure SME Login
GET	/api/user/me	Fetch Current SME Profile (Protected)
