# Step 1: Use a base image with JDK installed
FROM openjdk:17-jdk-alpine

# Step 2: Create a directory for the app
WORKDIR /app

# Step 3: Copy the application's JAR file to the container
COPY /build/libs/spring-learning-0.0.1-SNAPSHOT.jar /app/spring-learning-0.0.1-SNAPSHOT.jar

# Step 4: Expose the necessary port (if your application runs on port 8080, for example)
EXPOSE 8080

# Step 5: Define the entry point to run the app
ENTRYPOINT ["java", "-jar", "/app/spring-learning-0.0.1-SNAPSHOT.jar"]
