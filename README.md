# Spring Boot Starter CLI (Day 11)

First Spring Boot project built via [Spring Initializr](https://start.spring.io).  
This project runs as a **CLI app** (not a web server yet) and demonstrates **Dependency Injection (DI)** and **Spring Boot project structure**.

## Concepts Covered

- Spring Boot application bootstrap
- Dependency Injection with `@Service` and `@Component`
- CommandLineRunner to run CLI code
- Separation of concerns (Service = logic, Controller = CLI)

## Run

```bash
mvn clean package
java -jar target/spring-boot-starter-cli-0.0.1-SNAPSHOT.jar
```
