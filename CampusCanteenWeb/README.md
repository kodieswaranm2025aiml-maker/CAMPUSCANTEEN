# Campus Canteen Management System

A browser-based Campus Canteen application built in the same project style as the supplied DisasterRescueSystem sample.

## Technology
- Java 17
- Spring Boot 3.3.5
- Spring MVC + Thymeleaf
- Spring Data JPA / Hibernate
- Spring Security with BCrypt password hashing
- MySQL 8
- Maven

## Features
- Student registration and secure login
- Staff login
- Browse food menu and place orders
- Automatic total calculation and order token
- Student order history and status tracking
- Staff order queue and status updates
- Staff menu management and availability toggle
- Database persistence using MySQL

## Run
1. Install JDK 17, Maven and MySQL 8.
2. Create the database by running `database.sql` in MySQL Workbench.
3. Open `src/main/resources/application.properties` and set `spring.datasource.password` to your own MySQL password.
4. Open this folder in VS Code or IntelliJ.
5. Run `mvn spring-boot:run`.
6. Visit `http://localhost:8080`.

## Demo accounts
- Staff username: `staff`
- Staff password: `staff123`
- Student: create an account using the Register page.

## Project architecture
`Browser → Controller → Service → Repository → JPA/Hibernate → MySQL`

- `controller`: handles browser requests and responses
- `service`: business rules such as order validation and total calculation
- `repository`: database access through Spring Data JPA
- `entity`: Java classes mapped to database tables
- `config`: Spring Security configuration
- `templates`: Thymeleaf HTML pages
- `static`: CSS and frontend assets

## Notes
- This project does not use JavaFX.
- Passwords are stored as BCrypt hashes.
- Hibernate creates/updates tables using `spring.jpa.hibernate.ddl-auto=update`.
- Demo staff credentials are for academic demonstration; change them before real deployment.
