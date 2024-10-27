# Start with a base image that has Java
FROM eclipse-temurin:17-jdk

# Set the working directory
WORKDIR /app

# Copy the application's JAR and dependencies
COPY target/member-service-authorization-server-0.0.1-SNAPSHOT.jar app.jar

# Copy the realm JSON file into the image
COPY src/main/resources/people-system-realm.json /opt/keycloak/data/import/people-system-realm.json

# Expose port 8083
EXPOSE 8083

# Set the environment variable for Spring profile
ENV SPRING_PROFILES_ACTIVE=platform

# Run the application with the specified profile
ENTRYPOINT ["java", "-jar", "/app/app.jar", "--spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]
