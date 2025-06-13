# ----- Build Stage -----
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# ----- Runtime Stage -----
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.war app.war
ENTRYPOINT ["java", "-jar", "app.war"]