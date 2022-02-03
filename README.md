###      CUMI(Can You May I) Backend

### Introduction

A portal where a user can ask for help OR can provide help.
It's an application where a user can be a job provider or can look for a job. This application is built for four 
categories of jobs:
- Tutor / Pet Care / Baby Sitting / Garden Care

This is the backend part of the application which provides APIs CRUD functionalities for requirements/applications.

ERD Diagram
- [Planning ERD](planning/erd.png)
- [Final ERD](planning/CPBackend.jpeg)

### MVP

Minimum viable product is a working database for:

- User, Applications, Requirements, JobTypes models.
- All the models except User and JobType will have the four CRUD endpoints created using REST conventions.
- When invalid requests are made, the user will be notified by proper error messages.
- A user can register and login to perform various operations.
- Also contains endpoints for **open** requirements/applications and **fulfilled** requirements/applications.
 
User Stories / EndPoints
- [User Stories & EndPoints](planning/User%20Stories%20&%20EndPoints)

### Bonus
- A user can see their profile

### Wins
- Learned how to make a Full stack application using different frameworks
- Writing customize queries in Spring Boot (using @Query)
- Deployment on front and back ends
- How to realize an idea into a running applications
- Learned how to manage Postman for different environments/users

### Hurdles
- Handling queries for multi user scenarios
- Tackling CORS issues

### Challenge
- Identifying all the different outcomes and different query patterns

### Future Implementations
- Validations
- Dynamically adding various job types and new fields
- Add unit tests
- Allow a user to update their password, profile

### Technologies Used
- Lucidchart - to create the ERD
- IntelliJ
- Spring Boot
- Maven
- pgAdmin
- postgres
- Postman - used to test our end points
- JWT - used as security for user login

### Installation Instructions

- Fork and clone the repository.
- Using postgres, create a database called cpbackendapp
- Open the file CPBackendApp/src/main/resources/application-dev.properties and change lines 1 to the
  proper port number (9092 recommended) and 3, 4 & 5 to be your postgres DB, username and password

### Resources
- [Spring CORS](https://www.baeldung.com/spring-cors)
- [Setting environment variables](https://stackoverflow.com/questions/35531661/using-env-variable-in-spring-boots-application-properties)
- stackoverflow for tackling various errors


