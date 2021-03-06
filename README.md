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


**Docker Compose**

version: "3.8"

networks:
  backend:
    external: false
    name: backend
services:
  mymoviedb:
    networks:
      - backend
    image: mongo
    container_name: mymoviedb
    ports:
      - 27017:27017
  movie-app-image:
    networks:
      - backend
    image: movie-app-image
    container_name: movie-app-image
    ports:
      - 8080:8080
    links:
      - mymoviedb


**Docker Mongo DB**

docker run -d -p 27017:27017 --name <mongo_container_name> --net backend mongo:latest


