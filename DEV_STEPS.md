# MyBatis + Spring Boot Project Development Guide

This guide will walk you through building a modern Java application using Spring Boot 3.x and MyBatis with PostgreSQL. Each step is designed to be educational and follows best practices.

## Prerequisites

- Java 17 JDK installed
- Maven installed
- Docker installed (for Testcontainers)
- Your favorite IDE (IntelliJ IDEA recommended)

## Step 1: Project Setup

1. Create a new Spring Boot project using Spring Initializr:

   - Go to https://start.spring.io/
   - Set the following options:
     - Project: Maven
     - Language: Java
     - Spring Boot: 3.4.5 (latest stable)
     - Group: com.example
     - Artifact: mybatis-project
     - Name: mybatis-project
     - Description: Spring Boot + MyBatis + PostgreSQL Project
     - Package name: com.example.mybatis
     - Packaging: Jar
     - Java: 17

2. Add the following dependencies:

   - Spring Web
   - Spring Data JPA (for basic Spring Boot support)
   - PostgreSQL Driver
   - Lombok
   - Spring Boot DevTools

3. Download and extract the project to your workspace

## Step 2: Project Structure

Create the following directory structure:

```
src/main/java/com/example/mybatis/
├── config/         # Configuration classes
├── domain/         # Domain entities
├── mapper/         # MyBatis mapper interfaces
├── repository/     # Repository interfaces
├── service/        # Service layer
└── controller/     # REST controllers

src/main/resources/
├── mapper/         # MyBatis XML mapper files
└── application.yml # Application configuration
```

## Step 3: Domain Model

1. Create the User entity in `src/main/java/com/example/mybatis/domain/User.java`:
   - Implement basic fields: id, name, email
   - Add Lombok annotations
   - Add validation annotations

## Step 4: Database Configuration

1. Configure PostgreSQL in `application.yml`:

   - Set up database connection properties
   - Configure MyBatis settings
   - Add logging configuration

2. Create database migration scripts (if needed)

## Step 5: MyBatis Setup

1. Create UserMapper interface in `src/main/java/com/example/mybatis/mapper/UserMapper.java`:

   - Add `@Mapper` annotation
   - Implement CRUD operations using MyBatis annotations:
     - `@Insert` for insert
     - `@Select` for selectById and selectAll
     - `@Update` for update
     - `@Delete` for delete
   - Use `@Options(useGeneratedKeys = true)` for ID generation

2. No XML mapper files needed - using annotation-based approach for cleaner code

## Step 6: Service Layer

1. Create UserService interface in `src/main/java/com/example/mybatis/service/UserService.java`:

   - Define CRUD operation methods
   - Clear method naming convention

2. Implement UserServiceImpl in `src/main/java/com/example/mybatis/service/UserServiceImpl.java`:
   - Add `@Service` and `@Transactional` annotations
   - Use constructor injection for UserMapper
   - Add `@Transactional(readOnly = true)` for query methods
   - Implement all interface methods

## Step 7: REST Controller

1. Create DTO in `src/main/java/com/example/mybatis/dto/UserDTO.java`:

   - Add validation annotations
   - Separate API contract from domain model

2. Create UserController in `src/main/java/com/example/mybatis/controller/UserController.java`:
   - Add `@RestController` and base URL mapping
   - Implement CRUD endpoints with proper HTTP methods
   - Use `ResponseEntity` for HTTP responses
   - Add DTO-Entity conversion methods
   - Use constructor injection for service

## Step 8: Testing Setup

1. Add test dependencies to `pom.xml`:

   - Spock Framework
   - Testcontainers
   - Spring Boot Test

2. Create test structure:

```
src/test/groovy/com/example/mybatis/
├── integration/    # Integration tests
└── unit/          # Unit tests
```

## Step 9: Integration Tests

1. Create test configuration for Testcontainers
2. Implement integration tests for:
   - User creation
   - User retrieval
   - User update
   - User deletion

## Step 10: Documentation

1. Create/update README.md with:
   - Project description
   - Setup instructions
   - Running instructions
   - Testing instructions

## Step 11: Final Steps

1. Run all tests
2. Check code coverage
3. Review and refactor if needed
4. Document any additional setup steps

## Common Issues and Solutions

1. Database Connection Issues:

   - Check PostgreSQL is running
   - Verify connection properties
   - Check network connectivity

2. MyBatis Configuration Issues:

   - Verify mapper locations
   - Check XML namespace declarations
   - Validate SQL syntax

3. Testcontainers Issues:
   - Ensure Docker is running
   - Check port conflicts
   - Verify container startup

## Next Steps

After completing this guide, consider:

1. Adding more complex queries
2. Implementing pagination
3. Adding security
4. Implementing caching
5. Adding API documentation (Swagger/OpenAPI)

## Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [MyBatis Documentation](https://mybatis.org/mybatis-3/)
- [PostgreSQL Documentation](https://www.postgresql.org/docs/)
- [Testcontainers Documentation](https://www.testcontainers.org/)
- [Spock Framework Documentation](https://spockframework.org/)
