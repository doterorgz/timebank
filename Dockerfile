FROM openjdk:21-jdk-slim

# Copy the Spring Boot fat jar built in the boot module
COPY boot/target/*.jar /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
