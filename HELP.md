# Dockerizar Java Spring Boot Api y MongoDB

### Spring Boot Api
Dependencias:
- Spring Boot Starter Web
- Spring Boot Starter Data MongoDB
- Lombok

Proyecto de Ejemplo:
_http://localhost:8080/api/v1/movie_

**Crear una Película**
  
  // Request Body
  {
  "movieName" : "IronMan",
  "category" : "Action"
  }
  // Response
  Code: 200 (OK)
  {
  "movieName": "IronMan",
  "category": "Action"
  }

**Dockerfile**

FROM openjdk:11-jre-slim
MAINTAINER "Docker App <docker@app.com>"
WORKDIR /app

COPY ./target/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

EXPOSE 8080

**Docker Mongo DB**

docker run -d -p 27017:27017 --name <mongo_container_name> --net backend mongo:latest

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)

