# Campmaster

Campmaster is a web application for camping enthusiasts. It allows users to sign up and sign in with email and mobile verification. Users can perform CRUD operations for camping programs, events, reservations, and menu offerings.

## Architecture

Campmaster is built using a microservices architecture. It consists of six services:

1. **User Service**: Built with Node.js and MongoDB for user authentication.
2. **Camping Service**: Built with Spring Boot and H2 database for managing camping programs.
3. **Event Service**: Built with Spring Boot and H2 database for managing events.
4. **Reservation Service**: Built with Spring Boot and SQL database for managing reservations.
5. **Menu Service**: Built with Spring Boot and H2 database for managing menu offerings.
6. **Menu Offre Plat Service**: Built with Spring Boot and SQL database for managing menu offerings and special dishes.

Campmaster also utilizes the following technologies:

- Eureka for service discovery and registration.
- Docker for containerization.
- API Gateway for routing and load balancing.
- Config Server for centralized configuration management.

## Getting Started

To run the Campmaster application locally, follow these steps:

1. Clone the repository.
2. Set up the required databases (SQL and H2) and ensure they are accessible.
3. Configure the necessary environment variables.
4. Build and run each individual service using their respective build tools (e.g., Maven for the Spring Boot services).
5. Start the Eureka server, API Gateway, and Config Server.
6. Access the application through the designated endpoints.


## License

This project is licensed under the [MIT License](LICENSE).
