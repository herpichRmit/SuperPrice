# Use the official OpenJDK base image from Docker Hub
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file built by Maven into the container
COPY ./backend/target/backend-0.0.1-SNAPSHOT.jar ./app.jar

# Expose the port your application will listen on (adjust as needed)
EXPOSE 8080

# Command to run your application when the container starts
CMD ["java", "-jar", "app.jar"]
