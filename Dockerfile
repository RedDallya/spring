FROM openjdk:17-alpine

COPY target/spring-0.0.1-SNAPSHOT.jar /my-app.jar

ENTRYPOINT ["java", "-jar", "/my-app.jar"]