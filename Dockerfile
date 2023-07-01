FROM amazoncorretto: 17-alpine-jdk
COPY target/spring-0.0.1-SNAPSHOT.jar pia-app.jar
ENTRYPOINT ["java", "-jar", "/pia-app.jar"]