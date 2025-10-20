# Digitora - Digital Agency Website

This repository contains the source code for **Digitora**, a full-stack web application for a digital agency. The project is built using **Java** and the **Spring Boot** framework.

The application serves as a promotional website, allowing the agency to showcase its services, display its portfolio, and capture client inquiries through a contact form. It also includes a complete authentication system with role-based access for administrative management.

## Features ✨

* **User Authentication:** Secure user registration and login system using **Spring Security**.
* **Role-Based Access:** Distinct roles (e.g., `USER`, `ADMIN`) to protect administrative endpoints.
* **Service Management:** Admins can create, read, update, and delete (CRUD) the services offered by the agency.
* **Portfolio Management:** Admins can add, edit, and remove portfolio items, which are organized by category.
* **Category Management:** Admins can manage the categories used for services and portfolio items.
* **Contact Inquiries:** A public-facing contact form that saves inquiries to the database for review.
* **Dynamic Frontend:** A server-side rendered frontend built with **Thymeleaf**, including reusable header/footer fragments.
* **RESTful API:** A clear separation of concerns with controllers handling API and web requests.
* **Error Handling:** A global exception handler (`GlobalExceptionHandler.java`) for graceful error management.

## Technology Stack 🛠️

* **Backend:** Java 17+ & Spring Boot
    * **Spring Web:** For building RESTful APIs and web controllers.
    * **Spring Data JPA:** For database interaction and repositories.
    * **Spring Security:** For authentication and authorization.
* **Frontend:**
    * **Thymeleaf:** For server-side template rendering.
    * HTML, CSS, JavaScript.
* **Database:**
    * Spring Data JPA (configured for a relational database like H2, MySQL, or PostgreSQL).
    * `data.sql` for initial database seeding (e.g., creating default roles).
* **Build Tool:**
    * Apache Maven (using the Maven Wrapper `mvnw`).

## Getting Started

To run this project locally, you'll need:

* JDK 17 or later
* Apache Maven

---

### Installation & Setup

1.  **Clone the repository:**
    ```sh
    git clone [https://github.com/abinshah7777/abinshah7777-digitora.git](https://github.com/abinshah7777/abinshah7777-digitora.git)
    cd abinshah7777-digitora
    ```

2.  **Configure the database:**
    * Open the `src/main/resources/application.properties` file.
    * Update the `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` properties to point to your local or remote database (e.g., MySQL, PostgreSQL).

3.  **Run the application:**
    * You can use the included Maven wrapper to build and run the project.

    * **On macOS/Linux:**
        ```sh
        ./mvnw spring-boot:run
        ```
    * **On Windows:**
        ```sh
        mvnw.cmd spring-boot:run
        ```

4.  **Access the application:**
    * Once running, you can access the website at `http://localhost:8080`.

---

## Project Structure

The project follows a standard Spring Boot layout, separating concerns into distinct packages.
└── src/main/ ├── java/com/agency/digital_agency/ │ ├── DigitalAgencyApplication.java # Main application entry point │ ├── config/ # Spring Security and App configuration │ ├── controller/ # Handles HTTP requests (API & Web) │ ├── model/ # JPA entity classes (database models) │ ├── Repository/ # Spring Data JPA repository interfaces │ └── service/ # Business logic layer │ └── resources/ ├── application.properties # Main application configuration ├── data.sql # Initial data seeding ├── static/ # Static assets (CSS, JS) └── templates/ # Thymeleaf HTML templates ├── fragments/ # Reusable HTML parts (header, footer) └── projects/ # Specific project detail pages
