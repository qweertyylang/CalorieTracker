FROM  maven:3.9.2-eclipse-temurin-17-alpine AS build

WORKDIR /app

COPY . /app/

RUN mvn clean package -DskipTests

FROM amazoncorretto:17

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]