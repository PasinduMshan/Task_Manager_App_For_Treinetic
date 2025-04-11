# base images
FROM openjdk:21-jdk-slim

# app - customizeble name
ADD build/libs/Task_Manager_App_Backend-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that app will run on container
EXPOSE 8080

# Run the spring boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
