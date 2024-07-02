# ./server/Dockerfile
# Use the Maven 3.9.5 image as the build environment
FROM maven:3.9.6 AS build

# Set the working directory within the container to /app
WORKDIR /app

# Copy the content of the current directory into the /app directory in the container
COPY . .

# Run Maven to clean and install dependencies
RUN mvn clean install

# Use the OpenJDK 21 image as the base image for the final container
FROM openjdk:17

# Set the working directory within the container to /app
WORKDIR /app

# Copy the compiled JAR file from the build stage to the /app directory in the final container
COPY --from=build /app/target/*.jar api.jar

# Expose port 8080 to allow external connections
EXPOSE 8080

# Define the default command to run the Java application
CMD ["java", "-jar", "api.jar"]
