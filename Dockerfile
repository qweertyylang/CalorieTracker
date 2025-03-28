FROM  maven:3.9.2-eclipse-temurin-17-alpine AS build

WORKDIR /app

COPY pom.xml /app/

RUN mvn dependency:go-offline

COPY src /app/src

RUN mvn clean package -DskipTests

FROM amazoncorretto:17

WORKDIR /app

COPY --from=build /app/application/target/CalorieTracker-0.0.1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]