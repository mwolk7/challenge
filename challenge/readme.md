# Domus Back-End Developer Challenge

## Solution Overview
This project implements a REST API endpoint `/api/directors` that retrieves directors who have directed more movies than a given threshold.

### Features
- Fetches movie data from an external API.
- Filters movies released after 2010.
- Returns directors sorted alphabetically.
- Handles pagination intelligently.
- Includes Swagger documentation.

### Technologies Used
- Spring Boot
- WebFlux (WebClient)
- Lombok
- Swagger

### How to Run
1. Clone the repository.
2. Run `mvn spring-boot:run`.
3. Access Swagger at `http://localhost:8080/swagger-ui.html`.

### Testing
Run `mvn test` to execute unit tests.