FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copy Maven project files
COPY pom.xml .
COPY src ./src

# Package the application (will download dependencies and compile the project)
RUN mvn clean package -DskipTests

# 2. Run Stage
FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar task-manager.jar

# Expose the app port (change if needed)
EXPOSE 8080

# Run the app
ENTRYPOINT ["java","-jar","task-manager.jar"]